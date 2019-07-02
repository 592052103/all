package ssm;

import java.util.Date;

public class Worker {
	
	private Car car;
	
	public Worker(){
		
	}
	
	public Worker(Car car) {
		this.car = car;
	}
	
	public void gotoWork()throws LateException{
		try {
			car.run();
		}catch(CarWrongException e){
			walk();
			Date date = new Date(System.currentTimeMillis());
			String reason = e.getMessage();
			throw new LateException(date,reason);//创建一个LateException对象，并将其抛出
		}
	}
	
	public void walk() {
		
	}
	
	public static void main(String[] arg) throws LateException {
		
		Worker wk = new Worker();
		wk.gotoWork();
	}

}
