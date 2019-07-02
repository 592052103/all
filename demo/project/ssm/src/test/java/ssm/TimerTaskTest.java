package ssm;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest extends Thread{
	
	private int a;
	
	public void start() {
		super.start();
		Timer timer = new Timer(true);
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				reset();
				//System.out.println("-----------");
				
			}
			
		};
		
		timer.schedule(task, 1, 50);
	}
	public void reset() {
		a = 0;
	}
	
	public void run() {
		for (int i = 0; i < 1000; i ++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(getName() + ":" + a ++);
			yield();
		}
	}
	
	public static void main(String[] arg) {
		
		TimerTaskTest tt = new TimerTaskTest();
		tt.start();
		
	}

}
