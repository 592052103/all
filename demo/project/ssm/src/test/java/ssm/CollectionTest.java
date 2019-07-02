package ssm;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class CollectionTest {

	public static void main(String[] arg) {

		Person person1 = new Person();
		person1.setAge(1);
		person1.setName("zhang");
		Person person2 = new Person();
		person2.setAge(2);
		person2.setName("li");
		Person person3 = new Person();
		person3.setAge(1);
		person3.setName("zhang");
		Person person4 = new Person();
		person4.setName("wang");
		person4.setAge(1);
		//hashCode是用于散列数据的快速存取，根据存入对象的hashCode来进行排序
		/*HashSet<Person> hs = new HashSet<Person>();
		hs.add(person1);
		hs.add(person2);
		hs.add(person3);
		hs.add(person4);
		Iterator ite = hs.iterator();
		while(ite.hasNext()) {
			//hashSet不是根据存入的顺序进行排序的，而是通过hashCode来进行排序的
			//hashSet是通过hashCode来对里面的对象进行排序的
			Person person = new Person();
			person = (Person) ite.next();
			System.out.println(person.getName());
			System.out.println(person.getAge());
		}*/
		//LinkedHashSet是有序的，通过Linked链表进行排序,Hash表来保证数据的唯一性
		//hashSet允许存放空值
		//LinkedHashSet是以插入时候的值的顺序进行排列的
		LinkedHashSet<Person> lhs = new LinkedHashSet<Person>();
		/*lhs.add(person2);
		lhs.add(person4);
		lhs.add(person3);
		lhs.add(person1);*/
		lhs.add(null);
		Iterator ite = lhs.iterator();
		if (ite.hasNext()) {
			System.out.println(ite.next());
		}
		
/*		while(ite.hasNext()) {
			Person person = new Person();
			person = (Person) ite.next();
			System.out.println(person.getName());
			System.out.println(person.getAge());
		}*/
		//若要在hashSet中存在数据的唯一性，那么这个元素必须是唯一存在的，如果这个元素是唯一存在的，那么这个元素的hashCode码也必须是唯一的，如果产生了两个属性一样的对象，那么这个两个对象默认
		//为一样的对象，既然是一样的对象那么他们的hashcode码也必须是一样的

	}

}
