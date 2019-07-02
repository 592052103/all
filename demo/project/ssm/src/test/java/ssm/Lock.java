package ssm;

import java.util.concurrent.locks.Condition;

//描述lock接口信息
public interface Lock {
	
	void lock();//获得锁，如果锁已经被占用，则等待。
	
	//场景：如果发现该操作已经在执行，等待执行。这时可中断正在进行的操作立即释放锁继续下一操作
	//对于sychronized来说，如果一个线程在等待锁那么结果只有两种，要么它获得这把锁继续执行，要么它就保持等待。而重入锁，则提供了另一种可能，那就是线程可以被中断。
	//也就是在等待的过程中，程序可以根据需要取消对锁的请求，中断正式提供了一套类机制，如果一个线程正在等待锁，那么它依然可以接到一个通知，被告知，无需在等待，
	//可以停止工作了。
	void lockInterruptibly()throws InterruptedException;//获得锁，但优先相应中断
	
	boolean tryLock();//尝试获得锁，如果成功，返回true,失败则返回false,该方法不等待，立即返回
	
	//boolean tryLock(longtime,TimeUnitunit)throwsInterruptedException 在给定时间内尝试获得锁
	
	void unlock();//用来释放锁
	
	Condition newCondition();
	

}
