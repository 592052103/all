package ssm;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{
	
	private long waitTime;
	
	//创建MyCallable的构造方法
	public MyCallable(int timeInMillis) {
		
		this.waitTime = timeInMillis;
		
	}
	
	//创建线程的两种方式:1.继承Thread 2.实现runnable接口，这两种方式实现的结果的缺陷就是没有返回值
	//如果要获取执行结果，就必须通过共享变量或者使用通信的方式来达到效果，这样使用起来就不叫麻烦。
	//自从java 1.5以来，就提供了callable和future，通过它们就可以在任务执行完毕之后得到任务执行结果

	//callable接口代表一段可以调用并返回结果的代码
	//Future接口表示异步任务，是还没有完成的任务给出的未来的结果，所以说Callable用来产生结果，Future用来获取结果
	//callable用泛型去定义它的返回值类型，executors类提供了一些有用的方法在线程池中执行callable内的任务，由于callable任务是并行的，并行就是整体上看去
	//是并行额，其实在某个时间点只有一个线程在执行，我们必须等待它的返回结果。
	//java.util.concurrent.future对象为我们解决了这个问题，在线程提交callable任务后返回一个future对象，使用它可以知道callable任务的状态和得到Callable返回
	//的执行结果，Future提供了get()方法让我们可卡因等待callable结束并获取它的执行结果
	public String call() throws Exception {
		//方法中无法创建变量的范围修饰符，如Public,private
		// TODO Auto-generated method stub
		Thread.sleep(waitTime);
		return Thread.currentThread().getName();
	}
	
	//那么怎么使用callable呢？
	//一般情况下配合ExecutorService来使用的，在ExecutorService接口中声明了若干个submit方法的重载版本
	//<T>Future<T> submit(Callable<T> task);
	//<T>Future<T> submit(Runnable task);
	//Future<?> submit(Runnable task);
	//第一个submit方法里面的参数类型就是Callable,一般请跨国下使用第一个和第三个submit方法，第二个Submit方法很少用
	
	//Feture就是对具体的Runnable或者Callable任务的执行结果进行取消/查询是否完成,获取结果，必要时可以通过get方法获取执行结果，该方法会阻塞直到任务返回结果
	
	// public interface Future<V> {
	//boolean cancel (boolean mayInterruptIfRunning); 用来取消任务，如果取消任务成功则返回True，否则返回False，参数mayInterruptIfRunning
	//表示是否允许取消正在执行却没有执行完的任务，如果设置为True则表示可以取消正在执行过程中的任务，如果任务执行完成，则无论mayInterruptIfRunning
	//为True还是fales,此方法肯定返回false，即如果取消已经完成的任务会返回false；
	//如果任务正在执行，若mayInterruptIfRunning设置为True，则返回True。若mayInterruptIfRunning设置为False，则返回False；
	//如果任务还没有执行，则无论mayInterruptIfRunning为True还是false，肯定返回true;
	//isCancelled方法表示任务是否被取消，如果任务在任务正常完成前被取消则返回true
	//isDone方法表示任务是否已经完成，若任务完成则返回true
	//get()方法用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回。
	//get(long timeOut, TimeUnit uint)用来获取执行结果。如果在制定时间内，还没有获取到结果就返回NULL
	
	//也就是说future提供了三种功能：
	//1.判断任务是否完成
	//2。能够中断任务
	//3.能够获取任务执行结果
	
	//因为Future是一个接口，所以无法直接用来创建对象使用的，因此就有了下面的FutureTask
	
	//FutureTask实现了RunnableFure接口，而futureTask继承了Runnable和Future接口
	//FutureTask的构造函数，一个以Callable，一个以Runnable为参数，这些类之间额关联在与任务建模的办法非常灵活，允许你基于FutureTasl的Runnable特性（
	//因为它实现了runnable接口），把任务写程Callabel，然后封装进一个有执行调度者调度并在必要时可以取消FutureTask。
	//FutureTask可以有执行者调度，这一点很重要，它对外提供的方法就是Future和Runnable接口的组合，get(),cancel(),isDone(),isCancelled()和run()
	//而run方法都是由执行者调度，我们基本上不用直接调用它
	
	
	
	//boolean isCancelled();
	//boolean isDone();
	//V get() throw InterruptedException, ExecutionException;
	//V get(long timeOut, TimeUnit uint) throws InterruptedException, ExecutionException, TimeOutException;
	// }
	

}
