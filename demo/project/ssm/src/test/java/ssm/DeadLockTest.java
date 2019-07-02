package ssm;

public class DeadLockTest extends Thread {
	
	private Counter counter;
	public DeadLockTest(Counter counter) {
		this.counter = counter;
		start();
	}
	
	public DeadLockTest() {
		
	}
	
	public void run() {
		for(int i = 0; i < 1000; i ++) {
			counter.add();
		}
	}
	
	public static void main(String[] arg) {
		DeadLockTest.Counter counter1 = new DeadLockTest().new Counter();
		DeadLockTest.Counter counter2 = new DeadLockTest().new Counter();
		counter1.setFriend(counter2);
		counter2.setFriend(counter1);
		
		DeadLockTest dl1 = new DeadLockTest(counter1);
		DeadLockTest dl2 = new DeadLockTest(counter2);
		
	}
	
	class Counter {
		
		private int a;
		private Counter friend;
		
		public void setFriend(Counter friend) {
			this.friend = friend;
		}
		
		public synchronized void add() {
			a ++;
			Thread.yield();
			friend.delete();
			System.out.println(Thread.currentThread().getName()+ ": add");
		}
		
		public synchronized void delete() {
			a --;
			System.out.println(Thread.currentThread().getName() + "delete");
		}
	}
	
	

}
