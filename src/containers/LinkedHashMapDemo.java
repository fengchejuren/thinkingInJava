package containers;

import java.util.LinkedHashMap;

import utils.CountingMapData;

/**为了提高速度，LinkedHashMap散列化所有的元素，但是在遍历时，却又以插入时的顺序返回键值对
 * 此外，可以在构造器中设定LinkedHashMap，使其采用基于访问的最近最少使用（LRU Least Recently Used）算法。于是没有被访问的元素
 * 将会出现在队列的前面（可以看做需要被删除的）,而最近访问的元素将会出现在队列的末尾
 * @author Administrator
 *
 */
public class LinkedHashMapDemo {

	public static void main(String[] args) {
		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<Integer, String>(new CountingMapData(9));
		System.out.println(linkedMap);
		linkedMap = new LinkedHashMap<Integer, String>(16,0.75f,true);
		System.out.println(linkedMap);
		linkedMap.putAll(new CountingMapData(9));
		System.out.println(linkedMap);
		for(int i=0;i<6;i++)	//cause access
			linkedMap.get(i);
		System.out.println(linkedMap);
		linkedMap.get(0);
		System.out.println(linkedMap);
		linkedMap.get(4);
		System.out.println(linkedMap);
		
	}
	
	
	
}
