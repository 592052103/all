package ssm;

import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Set;

public class SoftReferenceTest {
	
	private String firstName;
	private String lastName;
	private static final Set<SoftReference<SoftReferenceTest>> names = new HashSet<SoftReference<SoftReferenceTest>>();
	public SoftReferenceTest(String firstName, String lastName) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SoftReferenceTest other = (SoftReferenceTest) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	
	public static SoftReferenceTest valueOf(String firstName,String lastName) {
		for (SoftReference<SoftReferenceTest> ref : names) {
			SoftReferenceTest name = ref.get();
			if (name != null && name.firstName.equals(firstName) && name.lastName.equals(lastName)) 
				return name;
		}			
			SoftReferenceTest name = new SoftReferenceTest(firstName,lastName);
			names.add(new SoftReference<SoftReferenceTest>(name));
			return name;	
	}
	
	public static void main(String[] arg) {
		SoftReferenceTest n1 = SoftReferenceTest.valueOf("小红", "王");
		SoftReferenceTest n2 = SoftReferenceTest.valueOf("小红", "王");
		SoftReferenceTest n3 = SoftReferenceTest.valueOf("小东", "张");
		SoftReferenceTest n4 = new SoftReferenceTest("小红", "王");
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n1 == n2);
		Set<SoftReferenceTest> set = new HashSet<SoftReferenceTest>();
		set.add(n1);
		set.add(n2);
		set.add(n3);
		set.add(n4);
		System.out.println(set.size());
		
	}


	


     

}
