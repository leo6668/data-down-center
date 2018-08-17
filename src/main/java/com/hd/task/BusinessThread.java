package com.hd.task;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	private List<Object> downQueue = new ArrayList<Object>();

	@PostConstruct
	private void downTask() throws InterruptedException{
		downQueue.add(new Object());
		downQueue.add(new Object());
		downQueue.add(new Object());
		while(true){
			if(downQueue.size() == 0 ){
				logger.info("任务队列为空,无需处理>>>>>>");
				Thread.sleep(30000);
				continue;
			}
			
			for (int i = 0; i < downQueue.size(); i++) {
				pool.execute(new Runnable() {
					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName()+"执行了>>>>>>>>>>downQueue="+downQueue.size());
						System.out.println("downQueue sizie="+downQueue.size());
						downQueue.removeAll(downQueue);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
			}
		}
	}
}
