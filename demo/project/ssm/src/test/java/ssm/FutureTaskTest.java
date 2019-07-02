package ssm;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskTest {
	
	//实现Callable接口通过任务调度其FutureTask来实现线程的任务调度
	public static void main(String[] arg) {
		//构造方法，创建被调度线程对象
		//创建一个有值的构造方法，只是我们限定了这个对象是需要包含属性值的，无其他任何作用
		CallableThreadTest callableThreadTest1 = new CallableThreadTest(/*1000*/);
		CallableThreadTest callableThreadTest2 = new CallableThreadTest(/*1000*/);
		
		//将线程任务包装到FutureTask中
		FutureTask<String> futureTask1 = new FutureTask<String>(callableThreadTest1);//将callable写的调度任务封装到一个FutureTask任务中
		FutureTask<String> futureTask2 = new FutureTask<String>(callableThreadTest2);
		
		//创建线程调度池，用于对线程任务的调用
		//创建线程调度池后调度线程是并行执行的
		ExecutorService executor = Executors.newFixedThreadPool(5);//通过ExecutorService创建一个线程池，并且返回executor实例对象
		executor.execute(futureTask1);
		executor.execute(futureTask2);
		
		//线程执行完毕以后我们是否应该关闭线程池呢？答案：是的，要关闭线程池，那么我们可以通过包装的FutureTask接口来获取线程的执行情况

		//那么我们需要获取线程的执行情况，如何获取呢？
		//1.当两个线程都执行完毕以后，我们需要关闭线程池，因此我们需要对线程池的执行完毕的情况做判断
		//我们可以通过future这个对象获取线程的执行情况
		//如上所述创建的线程都是并行执行的，和实现runnable接口与继承Thread类，没有别的区别
		
		//需要关闭线程，我们需要做一个死循环，假定条件一直为真
		while(true) {
		if (futureTask1.isDone() && futureTask2.isDone()) {
			executor.shutdown();//创建线程池执行任务完毕后，我们要关闭线程池
			System.out.println("Done");
			return;
			//到此结束，不继续往下面执行
		}
		
		//如果我们相对线程的执行顺序做排序，我们需要等待某个指定的线程执行完毕，才释放cpu资源给下一个线程调用
		if (!futureTask1.isDone()) {
			//我们需要占用资源，等该线程执行完
			try {
				//任务1没有完成需要等待
				System.out.println("FutureTask1 outPut=" + futureTask1.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		//我们判断线程1执行完毕以后，是否需要判断线程2是否执行完毕？
		System.out.println("-----等待线程2执行完毕任务--------------");		
		//规定在指定的时间范围内完成线程任务
		try {
			String s = futureTask2.get(2000, TimeUnit.MILLISECONDS);			
			if (s != null) {
				System.out.println("FutureTask2 OutPut=" + s);
			}
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}  
  }		
}
