package ssm;

public class RunnableTest implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("MyThreadRun()");
		Person person1 = new Person();
		person1.setAge(1);
		person1.setName("zhao");
		RunnableMethod(person1);
	}
	
	public static void main(String[] arg) {
		RunnableTest runnableTest1 = new RunnableTest();
		RunnableTest runnableTest2 = new RunnableTest();
		runnableTest1.run();
		runnableTest2.run();
	}
	
	public void RunnableMethod (Person person) {
		
		System.out.println(person.getName() + "-------------" + person.getAge());
		
	}

}
