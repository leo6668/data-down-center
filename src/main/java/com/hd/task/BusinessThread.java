package com.hd.task;
import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.hd.bean.ImageSource;
import com.hd.bean.VideoSource;
import com.hd.bean.VideoSourceExample;
import com.hd.bean.VideoSourceExample.Criteria;
import com.hd.common.Constants;
import com.hd.mapper.ImageSourceMapper;
import com.hd.mapper.VideoSourceMapper;
import com.hd.service.DownImageService;
import com.hd.service.DownVideoService;
import com.hd.utils.CommonFunc;

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
	
	@Autowired
	private ImageSourceMapper imageSourceMapper;


	//@PostConstruct
	@Scheduled(cron = "0 0 0/1 * * ?")
	private void downVideoTask() throws InterruptedException {
		List<VideoSource> queryVideo = this.queryVideo(videoSourceMapper);
		logger.info("本次下载视频队列大小为:{}",queryVideo.size());
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
	
	//@PostConstruct
	@Scheduled(cron = "0 0 0/1 * * ?")
	private void downImageTask() throws InterruptedException {
		List<VideoSource> queryVideo = this.queryVideoList(videoSourceMapper);
		logger.info("本次下载图片队列大小为:{}",queryVideo.size());
		for (VideoSource videoSource : queryVideo) {
			String localImageId = CommonFunc.getID();
			for (int i = 1; i <= 10; i++) {
				int indexOf = videoSource.getLinkUrl().indexOf(".mp4");
				String fileName = videoSource.getLinkUrl().substring(indexOf-4, indexOf)+","+i+".jpg";
				String imageUrl = videoSource.getImageUrl()+i+".jpg";
				
				int index = videoSource.getLinkUrl().indexOf(".mp4");
				String imageId = videoSource.getLinkUrl().substring(index-4, index)+","+i;
				this.insertImageSource(imageId,fileName,imageUrl,localImageId,videoSource);
				logger.info("imageId={},fileName={},localImageId={},保存图片信息入库成功!",imageId,fileName,localImageId);
				pool.execute(new Runnable() {
					@Override
					public void run() {
						try {
							downImageService.downloadImage(localImageId,imageId,imageUrl,fileName,imageSourceMapper);
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
	
	private List<VideoSource> queryVideoList(VideoSourceMapper videoSourceMapper){
		VideoSourceExample videoSourceExample = new VideoSourceExample();
		Criteria createCriteria = videoSourceExample.createCriteria();
		List<VideoSource> selectByExample = videoSourceMapper.selectByExample(videoSourceExample);
		return selectByExample;
	}
	
	
	//修改文件状态
	private boolean updateVideoStatus(VideoSource videoSource){
		videoSource.setDownStatus(1);
		int updateByPrimaryKey = videoSourceMapper.updateByPrimaryKey(videoSource);
		return updateByPrimaryKey > 0 ? true : false;
	}
	
	private boolean insertImageSource(String imageId,String fileName,String imageUrl,String localImageId,VideoSource videoSource) {
		ImageSource imageSource = new ImageSource();
		imageSource.setImageId(imageId);
		imageSource.setImageLink(imageUrl);
		imageSource.setImageStatus(0);
		imageSource.setLocalImageId(localImageId);
		imageSource.setLocalImagePath(Constants.IMAGE_PATH);
		int insertSelective = imageSourceMapper.insertSelective(imageSource);
		return insertSelective > 0 ? true : false;
	}
}
