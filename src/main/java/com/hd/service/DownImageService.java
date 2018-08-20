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
public class DownImageService {
	private static Logger logger = LoggerFactory.getLogger(DownImageService.class);
	
	private VideoSourceMapper videoSourceMapper;
	
	public DownImageService(VideoSourceMapper videoSourceMapper) {
		super();
		this.videoSourceMapper = videoSourceMapper;
	}

	public boolean videoDownload(String videoUrl,String fileName,VideoSourceMapper videoSourceMapper){
		logger.info("开始下载文件。。。。。。");
		boolean videoDownload = DownUtils.videoDownload(videoUrl, fileName);
		if(videoDownload){
			VideoSource videoSource = new VideoSource();
			videoSource.setDownStatus(2);
			videoSourceMapper.updateByPrimaryKey(videoSource);
		}
		return videoDownload;
	}
}