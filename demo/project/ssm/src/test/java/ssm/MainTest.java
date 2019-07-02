package ssm;

import java.util.HashSet;
import java.util.Set;

public class MainTest extends Thread {
	
	
	
	/*MainTest(int v){
		System.out.println("another constructor");
	}
	
	MainTest(){
		System.out.println("default constructor");
	}
	
	void method() {
		System.out.println("from A");
	}*/
	
	private int a = 0 ;
	//private static int count = 0;
	
/*	public void start() {
		System.out.println("调用start方法");
		System.out.println(Thread.currentThread().getName() + ":" + a);
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//super.start();
		//run();
		//System.out.println(currentThread().getName()+"第"+(++ count)+"个matchine线程启动");
	}*/
	
	public void run() /*throws CarWrongException*/ {
		
		for (a = 0; a < 50; a++) {
			System.out.println(currentThread().getName()+":"+a);
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getPriority());
	/*		try {
				sleep(6000);
			}catch(InterruptedException e) {
				throw new RuntimeException(e);
			}*/
		}
		
/*		int i = 0;
		try {
			if (i == 0) {
				throw new CarWrongException("车子无法刹车");
			}
		}catch(CarWrongException e) {
			//System.out.println("catch捕捉到的异常信息" +e.getMessage());
			e.printStackTrace();
		}*/
	
	}
	
/*	private String name;
	private int age;*/
/*	int var1;
 * 
 * 
 * 
 * 
 * 
 * 
 * 
	final int var2 = 0;*/
	
	//static {
/*		MainTest mt = new MainTest();
		mt.var1 = 2;*/
		
		

	//}
	
/*	MainTest(){
		this.();
		var1 = 1;
	}*/
	
/*	MainTest(int x){
		var1 = x;
	}*/
/*	static final int a = 1;
	static final int b;
	static {
		b = 2;
	}*/

	
/*	public void MainTest(String name,int age) {
		
	}
	
	public void MainTest(String name) {
		
	}*/

	public static void main(String[] arg) throws Exception {
		
		MainTest mt1 = new MainTest();
		
		Thread t1 = new Thread(mt1);
		t1.setPriority(MAX_PRIORITY);
		t1.start();
		
		//Thread t2 = new Thread(mt1);
		//MainTest mt2 = new MainTest();
		//mt2.setPriority(MIN_PRIORITY);
		//t2.setPriority(MIN_PRIORITY);;
		
		//t1.start();//MainTest执行线程的run方法
		//t2.yield();
		//t2.start();
		//yield();
		for (int i = 0; i < 1000; i++) {
			sleep(1000);
			System.out.println(i);
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getPriority());
		}
		//mt2.start();//主线程执行MainTest的run方法
		
/*		new MainTest().method();
		
		MainTest mt = new MainTest() {
			void method() {
				System.out.println("from anonymous");
			}
		};
		mt.method();*/
		/*MainTest mt = new MainTest();
		mt.run();*/
/*		Set<String> st = new HashSet<String>();
		Thread.sleep(3000);
		throw new Exception("测试");*/
		/*String a = "hello";
		st.add(a);
		a = null ;
		st.remove(a);
		System.out.println(st.size());
		for (String x : st) {
			System.out.println(x);
		}*/
		
		
		
	}
		

		/*StaticClassVariableTest scv1 = new StaticClassVariableTest();
		StaticClassVariableTest scv2 = new StaticClassVariableTest();
		
		System.out.println(scv1.a);
		System.out.println(scv2.a);
		
		scv1.a = 4;
		System.out.println(scv1.a);
		System.out.println(scv2.a);
		
		
		int[] a = null;
		
		//假定的存在的异常情况，将这种异常情况抛出去
		if (a == null ) {
			throw new IllegalArgumentException("定义的数组为空，是无效的数组");
		}
		


		
		
		
		

		
		//静态变量可以用类名直接访问

}
	public void testVariable() {

}*/
}