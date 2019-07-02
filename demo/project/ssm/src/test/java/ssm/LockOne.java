package ssm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;

public class LockOne implements Callable<String>{

	//构造一个重入锁对象
	public static ReentrantLock lock = new ReentrantLock();
	
	@Override
	public String call() throws Exception {
		
		try {
			//等待一个一个执行看那个对象先获取lock.lock()这个对象，谁获取到lock(),就占用了cpu的控制权
			//其它的对象想获取CPU的运行权限就要等到之前获取CPU权限的对象释放锁对象，即调用Unlock()方法。
			//如果对象1获取该锁，但是没有调用unlock那么其它的对象时没有办法获取该锁的
			lock.lock();
			System.out.println("获取锁对象");
			lock.unlock();
			
		}finally {
			//lock.unlock();
			System.out.println("释放锁对象");
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] arg) {
		
		LockOne lockOne = new LockOne();
		
		FutureTask<String> future1 = new FutureTask<String>(lockOne);
		FutureTask<String> future2 = new FutureTask<String>(lockOne);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(future1);
		executor.execute(future2);
		
		//while(true) {
			
		if (future1.isDone() && future2.isDone()) {
			executor.shutdown();//关闭线程池
			System.out.println("线程执行完毕关闭线程池");
			return ;
		}
		
		if(!future1.isDone()) {
			try {
				//如果线程1未执行完，则占用CPU，直到线程1执行完毕
				System.out.println("线程future1还没有执行完毕");
				System.out.println("FutureTask1 outPut=" + future1.get());
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//等待线程2执行线程
		System.out.println("----------等待线程2执行线程------------");
			try {
				String s = future2.get(2000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
  //}
}
