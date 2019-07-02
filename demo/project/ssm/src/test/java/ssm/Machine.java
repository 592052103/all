package ssm;

import java.util.Timer;
import java.util.TimerTask;

public class Machine extends Thread{
	
	private int a = 0;
	private Timer timer = new Timer(true); // 定义一个定时器
	
	public synchronized void reset() {a = 0;};
	
	public void run() {
		final Thread thread = Thread.currentThread();//取得当前的线程对象
		TimerTask timerTask = new TimerTask() {//定义一个继承TimerTask的匿名类
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(thread.getName() + "has wait for 3 seconds");
				thread.interrupt();//中断Machine线程的阻塞
			}
		};
		while(true) {
			synchronized(this) {
				while(a > 3) {
					timer.schedule(timerTask, 3000);//3秒后执行定时任务
					try {
						this.wait();
					}catch(InterruptedException e) {
						System.out.println(thread.getName() + "is interrupted");
						return;
					}
				}
				a ++;
				System.out.println("a =" + a);
			}
		}
	}
	
	public static void main(String[] arg) {
		Machine machine = new Machine();
		machine.start();
		
	}

}
