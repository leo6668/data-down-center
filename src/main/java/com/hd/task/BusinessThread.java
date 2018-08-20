package com.hd.task;
import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import com.hd.bean.VideoSource;
import com.hd.bean.VideoSourceExample;
import com.hd.bean.VideoSourceExample.Criteria;
import com.hd.mapper.VideoSourceMapper;
import com.hd.service.DownImageService;
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
	private DownImageService downImageService;
	
	@Autowired
	private VideoSourceMapper videoSourceMapper;


	@PostConstruct
	@Scheduled(cron = "0 0 0/1 * * ?")
	private void downVideoTask() throws InterruptedException {
		List<VideoSource> queryVideo = this.queryVideo(videoSourceMapper);
		logger.info("本次下载队列大小为:{}",queryVideo.size());
		for (VideoSource videoSource : queryVideo) {
			int indexOf = videoSource.getLinkUrl().indexOf(".mp4");
			String fileName = videoSource.getLinkUrl().substring(indexOf-4, indexOf+4);
			logger.info("更新文件：{},为下载中。。。。",fileName);
			this.updateVideoStatus(videoSource);
			pool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						downVideoService.videoDownload(videoSource,fileName,videoSourceMapper);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	@PostConstruct
	@Scheduled(cron = "0 0 0/1 * * ?")
	private void downImageTask() throws InterruptedException {
		List<VideoSource> queryVideo = this.queryVideo(videoSourceMapper);
		for (VideoSource videoSource : queryVideo) {
			for (int i = 1; i <= 10; i++) {
				int indexOf = videoSource.getLinkUrl().indexOf(".mp4");
				String fileName = videoSource.getLinkUrl().substring(indexOf-4, indexOf)+","+i+".jpg";
				String imageUrl = videoSource.getImageUrl()+i+".jpg";
				pool.execute(new Runnable() {
					@Override
					public void run() {
						try {
							//downImageService.videoDownload(imageUrl,fileName,videoSourceMapper);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		}
	}
	
	//查询未下载的文件
	private List<VideoSource> queryVideo(VideoSourceMapper videoSourceMapper){
		VideoSourceExample videoSourceExample = new VideoSourceExample();
		Criteria createCriteria = videoSourceExample.createCriteria();
		createCriteria.andDownStatusEqualTo(0);
		List<VideoSource> selectByExample = videoSourceMapper.selectByExample(videoSourceExample);
		return selectByExample;
	}
	
	//修改文件状态
	private boolean updateVideoStatus(VideoSource videoSource){
		videoSource.setDownStatus(1);
		int updateByPrimaryKey = videoSourceMapper.updateByPrimaryKey(videoSource);
		return updateByPrimaryKey > 0 ? true : false;
	}
}
