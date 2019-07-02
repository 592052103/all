package ssm;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

//利用treeMap进行排序
public class SortDemo {

	
	
    public static void main(String[] args) {
    	
/*        System.out.println("---------------- 默认 排序结果-----------------");
        createDefaultSortTreeMap();*/
    /*    System.out.println("---------------- 自定义 排序结果-----------------");
        createDefinitionSortTreeMap();*/
        
    	Person person1 = new Person();
    	Person person2 = new Person();
    	Person person3 = new Person();
    	Person person4 = new Person();
    	Person person5 = new Person();
    	
    	person1.setAge(1);
    	person1.setName("a");
    	
    	person2.setAge(2);
    	person2.setName("b");
    	
    	person3.setAge(3);
    	person3.setName("c");
    	
    	person4.setAge(4);
    	person4.setName("bb");
    	
    	person5.setAge(5);
    	person5.setName("aa");
    	
    	//这样更加灵活的实现键值的排序规则
    	//Map的键不能为基本的数据类型，必须为引用类型值
    	TreeMap<Integer,Person> treeMap = new TreeMap<Integer,Person>(new Comparator<Integer>() {
/*    		public int compare(String person1, String person2) {
    			
    			return person1.compareTo(person2);
    		}*/

			public int compare(Integer person1, Integer person2) {
				// TODO Auto-generated method stub
				return person1 - person2;
			}
    	});
    	
    	treeMap.put(1, person1);
    	treeMap.put(3, person2);
    	treeMap.put(5, person3);
    	treeMap.put(2, person4);
    	treeMap.put(4, person5);
    	
    	//需要对对象进行排序，无论是对TreeMap还是TreeMap只要该对象实现了Comparable接口,然后重写comparato方法就可以实现对对象的自定义的排序规则
    	for (Map.Entry<Integer, Person> entry : treeMap.entrySet()) {
    		System.out.println(entry.getKey() + "------------" + entry.getValue());
    	}
    	
    }
    
/*    public static void createDefaultSortTreeMap() {
        TreeMap<String, String> map = new TreeMap<String, String>();
        
        init(map);
        print(map);
    }*/
    
   /* public static void createDefinitionSortTreeMap() {
        
    	//构造TreeMap对象，添加comparator方法，根据键值大小比较输出信息、7、、
        TreeMap<String, String> map = new TreeMap<String, String>(new Comparator<String>() {

            public int compare(String o1, String o2) {
                    return o2.compareTo(o1);
            }
            
        });
        
        init(map);
        print(map);
    }*/
    
   /* public static void init(Map<String, String> map) {
        map.put("c", "1");
        map.put("a", "1");
        map.put("bb", "1");
        map.put("b", "1");
    }*/
    
/*    public static void print(Map<String, String> map) {
        Iterator<Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }*/
}
