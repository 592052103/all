package ssm;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetCollectionTest {
	
	public static void main(String[] arg) {
		
		//TreeSet是一个二叉树机制，每插入一个新元素都要和上面的一个元素进行比较,如果需要对元素进行比较需要对插入treeSet的集合对象进行排序
		//一个对象需要被排序的话，这个对象必须要实现comparable接口，然后重写comparato方法
		//TreeSet是用来排序的，可以指定一个顺序来对其进行排序，Tree代表的是二叉树，而二叉树存在的目的是为了对插入的对象进行排序
		//treeMap对于每个放进去的新值都要和二叉树上之前的值做比较，如果存入null值，无法生成正确的hashCode码，无法去做正确的比较，所以TreeMap不允许存入null值
		TreeSet<Person> ts = new TreeSet<Person>();
		ts.add(null);
		/*ts.add(new Person("张三",23));
		ts.add(new Person("李四",13));
		ts.add(new Person("周七",13));
		ts.add(new Person("王五",43));
		ts.add(new Person("赵六",33));*/
		System.out.println(ts.size());
		
		//报错person cannot be cast to java.lang.comparable
		Iterator<Person> ite = ts.iterator();
		if(ite.hasNext()) {
			System.out.println(ite.next());
/*			Person person = new Person();
			person = ite.next();
			System.out.println(person.getName());
			System.out.println(person.getAge());*/
		}
		//TreeSet类的add方法是把存入的对象提升为comparable类型
		//原因是我们需要告诉treeSet如何来进行元素比较，如果不指定就会抛出异常
		//TreeSet的底层是红黑树，那么它的存在是以二叉树的形式存在的，它的排序规则是新插入的元素和之前已插入的元素做比较，那么元素做比较就是对象做比较，比较的话就需要去实现Comparable接口，重写
		//compareto方法，若返回值为1则按从大到小的顺序，返回值为-1就是从小到大的顺序，返回值0就默认的顺序。
		
	}

}
