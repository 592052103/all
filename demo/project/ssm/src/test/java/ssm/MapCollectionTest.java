package ssm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapCollectionTest {
	
	public static void main(String[] arg) {
		
		Person person1 = new Person();
		person1.setAge(1);
		person1.setName("zhao");
		
		Person person2 = new Person();
		person2.setAge(2);
		person2.setName("qian");
		
		Person person3 = new Person();
		person3.setAge(3);
		person3.setName("sun");
		
		Person person4 = new Person();
		person4.setAge(4);
		person4.setName("li");
		
		Person person5 = new Person();
		person5.setAge(1);
		person5.setName("zhao");
		
		//TreeMap和HashMap都继承abstractMap,所以它是一个Map,即一个key-value集合
		//hashTable继承Dictionary,实现了Map,Cloneable,java.io.serializable接口
		//TreeMap实现了java.io.Serializable接口，意味着他能被序列化
		//TreeMap基于红黑树(red-black tree)实现，该映射根据其键的自然顺序进行排序，或者根据创建映射时提供的comparator进行排序，具体取决于使用的构造方法
		//TreeMap是非同步的，它的iterator方法返回的迭代器是fail-fast
		//TreeMap基于红黑树(red-black-tree)实现，该映射根据其键的自然顺序进行排序，或者根据创建映射时提供的comparator进行排序，具体取决于使用的构造方法
		//TreeMap的基本操作是containsKey,get,put和remove的时间复杂度是Log(n);treeMap是非同步的，它的返回的迭代器是fail-fast的。
		//treeMap实现继承与abstractMap,并且实现了navigableMap接口
		//TreeMap的本质是红黑树，它包含了几个重要的成员变量：root,size,comparator
		//root是红黑树的根节点,entry是红黑树的节点，它包含了红黑树的六个组成部分：key,value,left,right,parent,color，entry节点根据key进行排序
		//entry节点包含的内容为value
		//红黑树排序时，根据entry中的key进行排序，entry中的Key比较大小是根据比较器comparator来进行判断的，size是红黑树中节点的个数
		//treeMap的排序是根据key进行排序的，treeMap是通过红黑树实现的，treeMap提供了对TreeMap这棵树进行整体的操作方法，如获取子树，反向树
		//descendingKeyIterator实现的是逆序的排序
		
		
		
		/*Map<String,Person> concurrentHashMap = new ConcurrentHashMap<String,Person>();
		concurrentHashMap.put("zhao", person1);
		concurrentHashMap.put("qian", person2);
		concurrentHashMap.put("sun", person3);
		concurrentHashMap.put("li", person4);
		concurrentHashMap.put("zhao", person1);
		System.out.println(concurrentHashMap.size());
		
		for (Map.Entry<String, Person> entry : concurrentHashMap.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}*/
		
		/*Map<String,Person> hashTableMap = new Hashtable<String,Person>();
		hashTableMap.put("zhao", person1);
		hashTableMap.put("qian", person2);
		hashTableMap.put("sun", person3);
		hashTableMap.put("li", person4);
		hashTableMap.put("zhao", person1);
		System.out.println(hashTableMap.size());
		hashTableMap.put("zhao", person1);*/
		
		//可以使用containKeys方法来判断是否有某个键值存在，在多线程的环境下可以使用concurrentHashMap这个来帮助实现多线程下的环境
		//ConcurrentHashMap使用了分段锁
		//hashTable是线程安全的，不允许存在null的键值，具有线程安全的属性，不可以同时取到hashTable这个对象，获取该对象有先后顺序
		//java5出现了concurrentHashMap用这个可以替代HashTable
		//HashMap是线程不安全的，是fail-Fast迭代器，而Hashtable的enumerator迭代器不是fail-fast迭代器，所以当有其它线程改变了hashMap值的时候会
		//抛出ConCurrentModificationException,但迭代器本身不会抛出该异常
		//HashMap的iterator是failFast迭代器，当有其他线程改变了HashMap的结构(增加。删除，修改元素)将会抛出ConcurrentModifactionException异常
		//不过通过Iterator的remove方法移除则不会抛出异常，但这并不是一个一定发生的行为，要看JVM
		//JDK1.8之前HashTable是没有fast-fail机制的，在JDK1.8以后的版本中，HashTable也是使用fast-fail的
		//hashCode是JDK根据对象的地址或者字符串或者数字算出来的int类型的数值。然后再使用除留余数来获得最终的位置
		
		/*
		for (Map.Entry<String, Person> entry : hashTableMap.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}*/
		
		//hashMap也是可以同步的
		//Map m = collections.synchronizeMap(hashMap);
		
		
		/*Map<String, Person> map = new HashMap<String,Person>();
		map.put("zhao", person1);
		map.put("qian", person2);
		map.put("sun", person3);
		map.put("li", person4);
		map.put("zhao", person5);
		map.put(null, null);
		map.put(null, null);
		
		System.out.println(map.size());*/
		//HashMap是根据hashCode值去排序的，不是以存入值的顺序排序。
		//迭代Map集合对象的键可以通过map.keySet的方式去迭代Map对象的Key值
		//迭代Map集合对象的Value可以通过map.values的方法去迭代map集合对象的value值
		/*for (String str : map.keySet()) {
			System.out.println(str);
		}
		
		for (Person person : map.values()) {
			System.out.println(person.getAge() + "----------" + person.getName());
		}*/
		
		//第二种方式通过Map.entrySet使用iterator遍历key和value值，使用迭代器的方式对Map包了一层
		/*Iterator<Map.Entry<String,Person>> ite = map.entrySet().iterator();
		while(ite.hasNext()) {
			Map.Entry<String, Person> entry = ite.next();
			System.out.println(entry.getKey() + "-----------" + entry.getValue());
		}*/
		
		//entrySet大的效率是最高的，map本来就实现了一个entrySet的数组
		/*for (Map.Entry<String, Person> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "---------------" + entry.getValue());
		}*/
		
		
		
	}

}
