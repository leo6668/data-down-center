package com.hd;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hd.mapper")
public class HdserverApplication{
	private static Logger logger = LoggerFactory.getLogger(HdserverApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HdserverApplication.class, args);
	}
}
