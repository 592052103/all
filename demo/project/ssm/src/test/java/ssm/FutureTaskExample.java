package ssm;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskExample {
	
	public static void main(String[] arg) {
		
		MyCallable callabel1 = new MyCallable(1000);
		MyCallable callabel2 = new MyCallable(1000); // 要执行的任务
		
		FutureTask<String> futureTask1 = new FutureTask<String>(callabel1); //将Callable写的任务封装到一个由执行者调度的FutureTask对象。
		FutureTask<String> futureTask2 = new FutureTask<String>(callabel1);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);//创建线程池并返回ExecutorService实例
		executor.execute(futureTask1);//执行任务
		executor.execute(futureTask2);
		
		while (true) {
			
			try {
				
				if(futureTask1.isDone() && futureTask2.isDone()) { // 两个任务都完成
					System.out.println("Done");
					executor.shutdown();   // 关闭线程池和服务
					return;
				}
				
				if (!futureTask1.isDone()) { // 任务1没有完成，会等待。直到任务完成
					System.out.println("FutureTask1 outPut=" + futureTask1.get());
				}
				
				System.out.println("waiting for FutureTask2 to complete");
				String s = futureTask2.get(200L,TimeUnit.MILLISECONDS);
				
				if (s != null) {
					System.out.println("FutureTask2 OutPut=" + s);
				}
			}catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
				
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		
	}

}
