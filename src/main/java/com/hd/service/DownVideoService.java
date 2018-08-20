package com.hd.service;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hd.HdserverApplication;

@Service
@Transactional
public class DownVideoService {
	private static Logger logger = LoggerFactory.getLogger(DownVideoService.class);
	public boolean videoDownload(String linkUrl, String fileName) {
		 try (FileOutputStream fos = new FileOutputStream("D:/video/20180817/"+fileName)) {
			 	logger.info("图片下载地址："+linkUrl);
	            URLConnection connection = new URL(linkUrl).openConnection();
	            long fileSize = connection.getContentLengthLong();
	            InputStream inputStream = connection.getInputStream();
	            byte[] buffer = new byte[10 * 1024 * 1024];
	            int numberOfBytesRead;
	            long totalNumberOfBytesRead = 0;
	            while ((numberOfBytesRead = inputStream.read(buffer)) != - 1) {
	                fos.write(buffer, 0, numberOfBytesRead);
	                totalNumberOfBytesRead += numberOfBytesRead;
	               System.out.println("fileName="+fileName+" 进度："+totalNumberOfBytesRead * 100 / fileSize + "%");
	            }
	        } catch (IOException ex) {
	        }
		System.out.println("fileName = "+ fileName +" 下载完成。。。");
		return true;
	}

}