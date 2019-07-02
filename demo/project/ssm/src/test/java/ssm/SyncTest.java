package ssm;

public class SyncTest {
	
	public static void main(String[] arg) {
		
		SyncTest.Stack stack = new SyncTest().new Stack("stack1");
		//生产者和消费者指向的是一个Stack的内存空间
		SyncTest.Producer producer = new SyncTest().new Producer(stack,"producer1");
		SyncTest.Consumer consumer = new SyncTest().new Consumer(stack,"consumer1");
		
		
		
	}
	
	class Producer extends Thread {
		private Stack theStack;//在堆中分配了该对象的内存空间
		
		public Producer(Stack s,String name) {
			super(name);
			theStack = s;
			start();//启动生产者线程，即调用run方法
		}
		
		public void run() {
			
			String goods;
			for (int i = 0; i < 200; i ++) {
				//System.out.println("point" + theStack.getPoint());
				goods = "goods" + (theStack.getPoint() + 1);
				theStack.push(goods);
				System.out.println(getName() + "push" + goods + "to" + theStack.getName());
				yield();
				
			}
			
		}
		
		
		
		
		
	}
	
	class Consumer extends Thread {
		private Stack theStack;
		
		public Consumer(Stack s,String name) {
			super(name);
			theStack = s;
			start();//启动消费者线程
		}
		
		public void run() {
			String goods;
			for (int i = 0; i < 200; i ++) {
				goods = theStack.pop();
				System.out.println(getName() + ":pop" + goods + "from" + theStack.getName());
				yield();
			}
		}
	
		
	}
	
	class Stack {
		
		private String name;
		private String[] buffer = new String[100];
		int point = -1;
		
		public Stack(String name) {this.name = name;}
		public String getName() {return name;}
		
		public synchronized int getPoint() {return point;}
		
		public synchronized String pop() {
			//synchronized(this) {//当一个对象的所有代码都是同步的等同于用synchronized把这个代码块给包裹起来
				String goods = buffer[point];
				buffer[point] = null;
				Thread.yield();
				point --;
				return goods;
			//}
		}
		
		public synchronized void push(String goods) {
			point ++;
			Thread.yield();
			buffer[point] = goods;
		}
		
		
	}
	

}
