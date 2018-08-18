package com.hd.service;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hd.mapper.MenuRoleMapper;
/**
 * @author admin
 */
@Service
@Transactional
public class DownVideoService {
	@Autowired
	MenuRoleMapper menuRoleMapper;

	private static void videoDownload(String url, String pathName){
		try {
			URL ul = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) ul.openConnection();
			BufferedInputStream bi = new BufferedInputStream(conn.getInputStream());
			FileOutputStream bs = new FileOutputStream(pathName);
			System.out.println("文件大约：" + (conn.getContentLength() / 1024) + "K");
			byte[] by = new byte[1024];
			int len = 0;
			while ((len = bi.read(by)) != -1) {
				bs.write(by, 0, len);
			}
			bs.close();
			bi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DownVideoService down = new DownVideoService();
		down.videoDownload("http://www.baidu.com", "D://aa");
	}
}
