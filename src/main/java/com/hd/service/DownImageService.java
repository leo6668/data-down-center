package com.hd.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hd.bean.ImageSource;
import com.hd.bean.VideoSource;
import com.hd.constants.Constants;
import com.hd.mapper.ImageSourceMapper;
import com.hd.utils.DownUtils;
import com.hd.utils.FileOperateUtils;

@Service
@Transactional
public class DownImageService {
	private static Logger logger = LoggerFactory.getLogger(DownImageService.class);

	public boolean downloadImage(String localImageId,String imageId,String imageUrl,String fileName,VideoSource videoSource,
			ImageSourceMapper imageSourceMapper){
		
		FileOperateUtils.createFolders(Constants.downDirectory, "/"+videoSource.getId());
		fileName = Constants.downDirectory+"/"+videoSource.getId()+"/"+fileName;
		
		logger.info("开始下载图片文件。。。。。。");
		int initStatus = 0;
		updateImageStatus(localImageId,imageId,initStatus,fileName,imageSourceMapper);
		
		boolean imageDownload = DownUtils.videoDownload(imageUrl, fileName);
		if(imageDownload){
			initStatus = 2;
			this.updateImageStatus(localImageId, imageId, initStatus,fileName, imageSourceMapper);
		}else{
			this.updateImageStatus(localImageId, imageId, initStatus, fileName, imageSourceMapper);
		}
		return imageDownload;
	}
	
	public boolean updateImageStatus(String localImageId,String imageId,Integer status,String fileName,ImageSourceMapper imageSourceMapper) {
		ImageSource imageSource = new ImageSource();
		imageSource.setImageId(imageId);
		imageSource.setLocalImageId(localImageId);
		imageSource.setImageStatus(status);
		imageSource.setLocalImagePath(fileName);
		int updateByPrimaryKey = imageSourceMapper.updateImageStatus(imageSource);
		return updateByPrimaryKey > 0 ? true : false;
	}
}