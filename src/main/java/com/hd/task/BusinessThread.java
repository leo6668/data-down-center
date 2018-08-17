package com.hd.task;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
/**
 * @author leo
 */
@Component
public class BusinessThread {
	private static Logger logger = LoggerFactory.getLogger(BusinessThread.class);
	@Autowired
	private ThreadPoolTaskExecutor pool;
	
	private Queue<Object> downQueue = new LinkedBlockingQueue<Object>();

	@Scheduled(cron = "0 0 0/1 * * ?")
	@PostConstruct
	public void initData() {
		System.out.println("添加数据。。。");
		for (int i = 0; i < 20; i++) {
			downQueue.add(new Object());
			System.out.println("添加数据中。。。");
		}
	}
	
	@PostConstruct
	private void downTask() throws InterruptedException{
		while(true){
			if(downQueue.size() == 0 ){
				logger.info("任务队列为空,无需处理>>>>>>");
				Thread.sleep(3000);
				continue;
			}
			
			for (int i = 0; i < downQueue.size(); i++) {
				pool.execute(new Runnable() {
					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName()+"执行了>>>>>>>>>>downQueue="+downQueue.size());
						downQueue.remove(downQueue);
						System.out.println("downQueue sizie="+downQueue.size());
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
		}
	}
}
