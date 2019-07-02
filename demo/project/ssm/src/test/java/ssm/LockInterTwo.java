package ssm;

import java.util.concurrent.locks.ReentrantLock;

public class LockInterTwo implements Runnable {
	
	public static ReentrantLock lock = new ReentrantLock(true);

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//lock.lockInterruptibly();
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "running");
			Thread.sleep(5000);
			lock.unlock();
			System.out.println(Thread.currentThread().getName() + "finished");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(Thread.currentThread().getName() + "interrupted");
		}
		
	}
	
	public static void main(String[] arg) {
		LockInterTwo lockInterTwo = new LockInterTwo();
		Thread t1 = new Thread(lockInterTwo);
		Thread t2 = new Thread(lockInterTwo);
		t1.start();
		t2.start();
		t2.interrupt();
		
	}

}
