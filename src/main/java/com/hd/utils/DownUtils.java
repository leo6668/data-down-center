package com.hd.utils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 下载工具类
 * @author leo
 */
public class DownUtils {
	private static Logger logger = LoggerFactory.getLogger(DownUtils.class);
	
	public static boolean videoDownload(String linkUrl, String fileName) {
		 try (FileOutputStream fos = new FileOutputStream(fileName)) {
	            URLConnection connection = new URL(linkUrl).openConnection();
	            long fileSize = connection.getContentLengthLong();
	            InputStream inputStream = connection.getInputStream();
	            byte[] buffer = new byte[10 * 1024 * 1024];
	            int numberOfBytesRead;
	            long totalNumberOfBytesRead = 0;
	            long cacheSchedule = 0;
	            if(fileSize <= 0){
	            	logger.info("文件名称：{},文件大小:{}kb,本次不进行下载......",fileName,fileSize/(1024));
	            	return false;
	            }
	            while ((numberOfBytesRead = inputStream.read(buffer)) != - 1) {
	                fos.write(buffer, 0, numberOfBytesRead);
	                totalNumberOfBytesRead += numberOfBytesRead;
	                long schedule = totalNumberOfBytesRead * 100 / fileSize;
	                long fileCount = fileSize/(1024);
	                long surplus = (fileCount-(totalNumberOfBytesRead/1024));
	                if(cacheSchedule != schedule){
	                	logger.info("文件名称：{},文件大小:{}kb,剩余:{}kb,下载进度：{}%",fileName,fileCount,surplus,schedule);
	                }
	                cacheSchedule = schedule;
	            }
	        } catch (IOException e) {
	        	logger.error("文件名称：{},下载异常！",fileName);
	        	e.printStackTrace();
	        	return false;
	        }
		return true;
	}
}
