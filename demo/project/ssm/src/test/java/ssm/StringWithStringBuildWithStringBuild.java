package ssm;

public class StringWithStringBuildWithStringBuild {
	
	public static void main(String[] arg) {
		
		String a = "aa";
		StringBuilder b = new StringBuilder("bb");
		StringBuffer c = new StringBuffer("cc");
		
		//这三类之间的主要区别在两个方面，即运行速度和线程安全方面
		//在运行速度方面，StringBuild > StringBuffer > String
		
		//String为字符串常量，而StringBuild和StringBuffer都为字符串变量
		
		//StringBuild为字符串变量是线程不安全的，StringBuffer是线程安全的，带有线程安全的机制，String是一个常量。
		
	}

}
