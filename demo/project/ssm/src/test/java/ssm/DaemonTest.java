package ssm;

public class DaemonTest extends Thread {
	
	private int a;
	private static int count;
	
	public void start() {		
		super.start();
		Thread deamon = new Thread() {
			public void run() {
				while(true) {
					reset();
					/*try {
						sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				}
			}
		};
		deamon.setDaemon(true);//必须在调用start方法之前将该线程置为后台线程
		deamon.start();
	}
	
	public void reset() {
		a = 0;
	}
	
	public void run() {
		while(true) {
			System.out.println("前台线程" + getName() + ":" + a ++);
			if (count ++ == 100) {
				break;
			}
			
			yield();
		}
	}
	
	public static void main(String[] arg) {
		
		DaemonTest dt = new DaemonTest();
		dt.start();
		try {
			dt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
	}
	

}
