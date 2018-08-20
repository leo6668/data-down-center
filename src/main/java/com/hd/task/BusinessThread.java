package com.hd.task;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.hd.bean.VideoSource;
import com.hd.bean.VideoSourceExample;
import com.hd.bean.VideoSourceExample.Criteria;
import com.hd.mapper.VideoSourceMapper;
import com.hd.service.DownVideoService;

/**
 * @author leo
 */
@Component
public class BusinessThread {
	private static Logger logger = LoggerFactory.getLogger(BusinessThread.class);
	@Autowired
	private ThreadPoolTaskExecutor pool;

	@Autowired
	private DownVideoService downVideoService;
	@Autowired
	private VideoSourceMapper videoSourceMapper;

	private List<Object> downQueue = new ArrayList<Object>();

	@PostConstruct
	private void downVideoTask() throws InterruptedException {
		List<VideoSource> queryVideo = this.queryVideo(videoSourceMapper);
		for (VideoSource videoSource : queryVideo) {
			int indexOf = videoSource.getLinkUrl().indexOf(".mp4");
			String fileName = videoSource.getLinkUrl().substring(indexOf-4, indexOf+4);
			pool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						downVideoService.videoDownload(videoSource.getLinkUrl(),fileName);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	@PostConstruct
	private void downImageTask() throws InterruptedException {
		List<VideoSource> queryVideo = this.queryVideo(videoSourceMapper);
		for (VideoSource videoSource : queryVideo) {
			for (int i = 1; i <= 10; i++) {
				int indexOf = videoSource.getLinkUrl().indexOf(".mp4");
				String fileName = videoSource.getLinkUrl().substring(indexOf-4, indexOf)+i+".jpg";
				String imageUrl = videoSource.getImageUrl()+i+".jpg";
				pool.execute(new Runnable() {
					@Override
					public void run() {
						try {
							downVideoService.videoDownload(imageUrl,fileName);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		}
	}
	
	private List<VideoSource> queryVideo(VideoSourceMapper videoSourceMapper){
		VideoSourceExample videoSourceExample = new VideoSourceExample();
		Criteria createCriteria = videoSourceExample.createCriteria();
		List<VideoSource> selectByExample = videoSourceMapper.selectByExample(videoSourceExample);
		return selectByExample;
	}
}
