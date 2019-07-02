package ssm;

public class innerClass {
	

	    int out_x = 0;

/*	    public void method() {
	    	System.out.println("--------------------------------");
	        Inner1 inner1 = new Inner1();
	        class Inner2 // 在方法体内部定义的内部类
	        {
	            public void method() {
	                out_x = 3;
	                System.out.println(out_x);
	            }
	        }
	        Inner2 inner2 = new Inner2();
	        inner2.method();
	        
	    }*/

	    class Inner1 // 在方法体外面定义的内部类
	    {
	    int inner1_x = 1;
	    int inner1_y = 2;
	    int inner1_z = out_x;
	    
	    class Inner2{
	    	
	   
	    	int inner2_x = 3;
	    	int inner2_y = 4;
	    	int inner2_z = out_x;
	    	int inner2_xx = inner1_x;
	    }
	    
	    
	}

	    public void test() {
	    	//int a = inner_x ;
	    	Inner1 in11 = this.new Inner1();
	    	Inner1 in1 = new Inner1();
	    	int a = in1.inner1_x;
	    	Inner1.Inner2 in2 = new Inner1().new Inner2();
	    	int out = new innerClass().out_x;
	    }
	    
	    public void method() {
	    	
	    	class B{
	    		int v1;
	    		int v2;
	    		
	    		class C{
	    			int v3;
	    			int v4;
	    		}
	    	}
	    	B b = new B();
	    	int x = b.v1;
	    	int y = b.v2;
	    	
	    	B.C c = new B().new C();
	    	int i = c.v3;
	    	int j = c.v4;
	    }
	    
	    
}
