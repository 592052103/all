package ssm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;

//这是一个失败的例子，在这个例子里面我们是要实现线程在等待锁的过程中，中断等待锁的过程，因为FutureTask是为了获取线程的执行状态，它封装了任务对象，但是要执行任务对象需要调executorService类中的execute方法
//ExcutorService中没有对线程中断的方法，所以这个例子是失败的
public class LockInterrupt implements Callable<String>{

	public static ReentrantLock lock = new ReentrantLock(true);
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		try {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "running");
		Thread.sleep(5000);
		lock.unlock();
		System.out.println(Thread.currentThread().getName()+ "finished");
		} catch(InterruptedException e){
			System.out.println(Thread.currentThread().getName() + "interrupted");
		}finally {
			//lock.unlock();
		}
		return null;
	}
	
	public static void main(String[] arg) {
		
		LockInterrupt lockInterrupt = new LockInterrupt();
		
		FutureTask<String> task1 = new FutureTask<String>(lockInterrupt);
		FutureTask<String> task2 = new FutureTask<String>(lockInterrupt);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(task1);
		executor.execute(task2);
		
		
		if (task1.isDone() && task2.isDone()) {
			
			executor.shutdown();
			System.out.println("线程已经执行完毕");
			return;
			
		}
		
		if (!task1.isDone()) {
			try {
				System.out.println("线程task1未执行完成任务，等待线程" + task1.get() +"执行完任务");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("等待线程2完成任务");
		if (!task2.isDone()) {
			try {
				System.out.println(task2.get(2000, TimeUnit.MILLISECONDS));
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
	}

}
