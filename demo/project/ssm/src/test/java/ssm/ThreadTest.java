package ssm;

//第一种实现线程的方法,extend Thread类
public class ThreadTest extends Thread{
	
	public void run() {		
		//在run方法中，写上自己的逻辑代码
		System.out.println("MyThread.run()");	
		Person person1 = new Person();
		person1.setAge(1);
		person1.setName("zhaoqian");
		testThread(person1);
		
	}
	

	
	public static void main(String[] arg) {
		
		ThreadTest thread1 = new ThreadTest();
		ThreadTest thread2 = new ThreadTest();	
		thread1.run();
		thread2.run();
		
	}
	
	public void testThread(Person person) {
		
		System.out.println(person.getAge() + "-----------" + person.getName());
	}
}
