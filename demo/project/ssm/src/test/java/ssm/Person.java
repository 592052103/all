package ssm;

public class Person /*implements Comparable<Person> */{
	
	private String name;
	
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		
	}
	
	public Person() {
		
	}
	
	@Override
	public String toString() {
		return "Person [name=" + this.name + ", age=" + this.age + "]";
	}

	//维护对象相等的协议，既然两个对象是相等的，那么它们的hashCode也应该相等
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}*/

	//如果不重写equals方法比较的是两个对象的地址
	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}*/

	/*public int compareTo(Person o) {
		// TODO Auto-generated method stub
		//比较直的返回值为正值则按从大到小的排序，比较值为负则按从小到大的顺序排序
		int num =  o.getAge() - this.age ;
		return num == 0 ? this.name.compareTo(o.getName()) : num;
	}*/
	
	
	

}
