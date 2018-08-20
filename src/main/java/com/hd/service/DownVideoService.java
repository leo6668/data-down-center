package com.hd.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hd.bean.VideoSource;
import com.hd.mapper.VideoSourceMapper;
import com.hd.utils.DownUtils;

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
		logger.info("开始下载文件,{},>>>>>>>",fileName);
		String videoUrl = videoSource.getLinkUrl();
		long startTime = System.currentTimeMillis();
		boolean videoDownload = DownUtils.videoDownload(videoUrl, fileName);
		long endTime = System.currentTimeMillis();
		logger.info("文件下载完成,{},耗时：{},>>>>>>>",fileName,(endTime-startTime));
		if(videoDownload){
			videoSource.setDownStatus(2);
			logger.info("开始更新文件状态：fileName={},为下载成功！",fileName);
			videoSourceMapper.updateByPrimaryKey(videoSource);
			logger.info("更新文件状态：fileName={},成功！",fileName);
		}
		return videoDownload;
	}
}