package ssm;

import java.util.concurrent.Callable;

public class CallableThreadTest implements Callable<String>{
	
	//实现Callable接口，调用call方法可以获取返回值，但是实现runnable方法，调用run方法没有返回值，不能通过FutureTask接口去获取线程的返回值信息
	//Callable接口的定义，Call安不了接口时一个泛型，该接口是实现线程的一种方法，其作为FutureTask的参数，来实现线程
	//因为callable接口定义了call方法，且call方法的返回值类型也是一个泛型，而其方法是含有返回值的，所以重写该方法的时候需要添加返回值
/*	public interface Callable<V>   
	{   
	    V call() throws Exception;   
	} */
	
	//声明对象属性
	private long waitTime;
	
	//添加对象的构造方法
/*	public CallableThreadTest(int timeMillis) {
		
		this.waitTime = timeMillis;
		
	}*/
	
	//调用线程的call方法
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		int i = 1;
		testThread();
		Thread.sleep(1000);
		System.out.println("执行线程任务" + i ++);
		return Thread.currentThread().getName();
	}
	
	public void testThread() {
		System.out.println("线程调用线程外面的方法");
	}

}
