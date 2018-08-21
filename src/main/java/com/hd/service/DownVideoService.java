package com.hd.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hd.bean.VideoSource;
import com.hd.constants.Constants;
import com.hd.mapper.VideoSourceMapper;
import com.hd.utils.DownUtils;
import com.hd.utils.FileOperateUtils;

@Service
@Transactional
public class DownVideoService {
	private static Logger logger = LoggerFactory.getLogger(DownVideoService.class);
	
	private VideoSourceMapper videoSourceMapper;
	
	public DownVideoService(VideoSourceMapper videoSourceMapper) {
		super();
		this.videoSourceMapper = videoSourceMapper;
	}

	public boolean videoDownload(VideoSource videoSource,String fileName,VideoSourceMapper videoSourceMapper){
		String videoUrl = videoSource.getLinkUrl();
		FileOperateUtils.createFolders(Constants.downDirectory, "/"+videoSource.getId());
		fileName = Constants.downDirectory+"/"+videoSource.getId()+"/"+fileName;
		
		long startTime = System.currentTimeMillis();
		boolean videoDownload = DownUtils.videoDownload(videoUrl, fileName);
		long endTime = System.currentTimeMillis();
		logger.info("文件下载完成,{},耗时：{},>>>>>>>",fileName,(endTime-startTime));
		if(videoDownload){
			videoSource.setDownStatus(2);
			videoSource.setHostDirectory(fileName);
			logger.info("开始更新文件状态：fileName={},为下载成功！",fileName);
			videoSourceMapper.updateByPrimaryKey(videoSource);
		}else{
			logger.info("开始更新文件状态：fileName={},为下载失败！",fileName);
			videoSource.setDownStatus(0);
			videoSource.setHostDirectory(fileName);
			videoSourceMapper.updateByPrimaryKey(videoSource);
		}
		return videoDownload;
	}
}