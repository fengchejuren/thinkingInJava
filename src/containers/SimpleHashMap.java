package containers;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import utils.Countries;

/**由于散列表中的槽位（slot）称为桶位（bucket）,所以我们将表示实际散列表的数组命名为bucket
 * 为使散列分布均匀，桶的数量使用质数
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
public class SimpleHashMap<K,V> extends AbstractMap<K, V> {

	static final int SIZE = 997;
	//you can't have a physical array of generics,but you can upcast to one
	@SuppressWarnings("unchecked")
	LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];
	
	public V put(K key,V value){
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index]==null)
			buckets[index] = new LinkedList<MapEntry<K,V>>();
		LinkedList<MapEntry<K, V>> bucket = buckets[index];
		MapEntry<K, V> pair = new MapEntry(key, value);
		boolean found = false;
		ListIterator<MapEntry<K, V>> iterator = bucket.listIterator();
		while(iterator.hasNext()){
			MapEntry<K, V> ipair = iterator.next();
			if(ipair.getKey().equals(key)){
				oldValue = ipair.getValue();
				ipair.setValue(value);
				found = true;
				break;
			}
		}
		if(!found)
			buckets[index].add(pair);
		return oldValue;
		
	}
	
	@Override
	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index]==null)	 return null;
		for(MapEntry<K, V> ipair:buckets[index]){
			if(ipair.getKey().equals(key))
				return ipair.getValue();
		}	
		return null;
	}
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		for(LinkedList<MapEntry<K, V>> bucket:buckets){
			if(bucket==null) continue;
			for(MapEntry<K, V> ipair:bucket)
				set.add(ipair);
		}
		return set;
	}

	
	public static void main(String[] args) {
		SimpleHashMap<String, String> map = new SimpleHashMap<String, String>();
		map.putAll(Countries.captials(25));
		System.out.println(map);
		System.out.println(map.get("American Samoa"));
		System.out.println(map.entrySet());
		
	}
	
	
}
