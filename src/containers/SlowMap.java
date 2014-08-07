package containers;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.CountingMapData;
import utils.Countries;

public class SlowMap<K,V> extends AbstractMap<K, V> {

	private List<K> kList = new ArrayList<K>();
	private List<V> vList = new ArrayList<V>();
	
	public V put(K key,V value){
		V oldValue = get(key);
		if(!kList.contains(key)){
			kList.add(key);
			vList.add(value);
		}else{
			vList.set(kList.indexOf(key), value);
		}
		return oldValue;
			
	}
	
	@Override
	public V get(Object key) {		//key is type Object,not K
		if(kList.contains(key))
			return vList.get(kList.indexOf(key));
		return null;
	}
	
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		Iterator<K> iteratorK = kList.iterator();
		Iterator<V> iteratorV = vList.iterator();
		while(iteratorK.hasNext()){
			set.add(new MapEntry(iteratorK.next(), iteratorV.next()));
		}
		return set;
	}

	public static void main(String[] args) {
		SlowMap<String, String> m = new SlowMap<String, String>();
		m.putAll(Countries.captials(15));
		System.out.println(m);
		System.out.println(m.get("Western Samoa"));
		System.out.println(m.entrySet());
		
	}
}
