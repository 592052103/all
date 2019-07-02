package ssm;

public class ThreadPriorityTest extends Thread {
	
	private static StringBuffer log = new StringBuffer();
	private static int count = 0;
	
	public void run() {
		for(int a = 0; a < 20; a ++) {
			log.append(currentThread().getName()+ ":" + a + "");
			if (++ count % 10 == 0) {
				log.append("\n");
			}
		}
		System.out.println(log);
	}
	
	public static void main(String[] arg) {
		ThreadPriorityTest tp1 = new ThreadPriorityTest();
		//ThreadPriorityTest tp2 = new ThreadPriorityTest();
		tp1.setName("m1");
		//tp2.setName("m2");
		tp1.start();
/*		try {
			tp1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main End");
		//tp2.start();
		/*while(tp1.isAlive() || tp2.isAlive()) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		}*/
	}

}
