package ssm;

public class StringBufferTest {
	
	public static void main(String[] arg) {
		
		StringBuffer stf = new StringBuffer("abc");
		boolean flag = stf.equals("abc");
		System.out.println(flag);
		String str = "abc";
		boolean flagStr = str.equals("abc");
		System.out.println(flagStr);
		//StringBuffer没有equals方法
		//String为字符串常量，stringBuild和stringBuffer为字符串变量，即string对象一旦创建就不能更改
		//java虚拟机栈，这个是线程私有的，神明周期与线程是同步的，每个方法在执行的时候都会创建一个栈帧，用于存储局部变量表，操作数栈，动态链接，方法出入口等
		//信息，每个方法的调用到执行完毕的过程就是一个栈帧入栈到出栈的过程。
		//虚拟机规定了两种异常情况，一种是虚拟机请求的栈深度大于虚拟机所允许的栈深度，这时候将会抛出stackoverflowerror异常如果虚拟机允许扩展栈的时候，
		//当扩展的时候没有办法达到内存分配的时候就会报出OutofMemoryerror的异常。
		//本地方法，与虚拟机栈执行的时候基本相同，唯一区别的就是虚拟机执行的是java方法，本地方法栈执行的是nativa方法。
		//堆区被java栈所允许共享的一块区域，主要存储的对爱的实例。
		//方法区，这个也是线程共享的内存区域，存储虚拟机加载的类信息，常量，静态变量，即时编译的代码数据等。
		//方法区在物理上也是不连续的，可以选择固定大小或者固定大小，还可以选择不实现垃圾收集，方法区的垃圾回收比较小，方法区是可以执行固定回收的，该区域主要执行
		//的常量池和类型的卸载，在方法区也规定当方法区无法满足内存空间的时候就抛出outofMemoryerror
		//java对象指的是引用类型的对象 stu存在java虚拟机栈上，new student()保存在java堆中，堆中记录了student类型的信息，包括方法，接口，对象
		//接口对象类型等地址，这些类型的执行数据存储在方法区中。
		//对象的访问方式，2种，句柄访问和直接地址访问。
		//GC回收机制，两种方法：引用计数法和可达性分析法
		//引用计数法，对象中添加一个引用计数器，每当有地方引用计数器就添加一，引用失效就减少1，计数器为0就不可用，缺点就在于无法处理对象直接相互引用的问题，
		//因为相互引用之后就无法让计数器归0，所以无法回收。
		//可达性分析：就是GC root，当一个对象没有任何引用链相连的时候，就可以堆该对象进行回收
		
		
		
		
		
	}

}
