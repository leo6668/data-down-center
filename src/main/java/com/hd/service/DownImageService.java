package com.hd.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hd.bean.ImageSource;
import com.hd.mapper.ImageSourceMapper;
import com.hd.utils.DownUtils;

@Service
@Transactional
public class DownImageService {
	private static Logger logger = LoggerFactory.getLogger(DownImageService.class);

	public boolean downloadImage(String localImageId,String imageId,String imageUrl,String fileName,
			ImageSourceMapper imageSourceMapper){
		logger.info("开始下载图片文件。。。。。。");
		int initStatus = 0;
		updateImageStatus(localImageId,imageId,initStatus,imageSourceMapper);
		
		boolean imageDownload = DownUtils.videoDownload(imageUrl, fileName);
		if(imageDownload){
			initStatus = 2;
			this.updateImageStatus(localImageId, imageId, initStatus, imageSourceMapper);
		}
		return imageDownload;
	}
	
	public boolean updateImageStatus(String localImageId,String imageId,Integer status,ImageSourceMapper imageSourceMapper) {
		ImageSource imageSource = new ImageSource();
		imageSource.setImageId(imageId);
		imageSource.setLocalImageId(localImageId);
		imageSource.setImageStatus(status);
		int updateByPrimaryKey = imageSourceMapper.updateImageStatus(imageSource);
		return updateByPrimaryKey > 0 ? true : false;
	}
}