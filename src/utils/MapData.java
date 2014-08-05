package utils;

import java.util.LinkedHashMap;

public class MapData<K,V> extends LinkedHashMap<K, V> {

	/** A single Pair generator
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param generator
	 * @param quantity 
	 */
	public MapData(Generator<Pair<K, V>> generator,int quantity){
		for(int i=0;i<quantity;i++){
			Pair<K, V> pair = generator.next();
			put(pair.key, pair.value);
		}
	}
	
	public MapData(Generator<K> generatorK,Generator<V> generatorV,int quantity){
		for(int i=0;i<quantity;i++){
			put(generatorK.next(), generatorV.next());
		}
	}
	
	public MapData(Generator<K> generator,V v,int quantity){
		for(int i=0;i<quantity;i++){
			put(generator.next(), v);
		}
	}
	
	public MapData(Iterable<K> genK,Generator<V> genV){
		for(K k:genK){
			put(k, genV.next());
		}
	}
	
	public MapData(Iterable<K> genK,V v){
		for(K k:genK){
			put(k, v);
		}
	}
	
	//Generic convenience methods
	public static <K,V> MapData<K, V> map(Generator<Pair<K, V>> generator,int quantity){
		return new MapData<K,V>(generator, quantity);
	}
	
	public static <K,V> MapData<K, V> map(Generator<K> genK,Generator<V> genV,int quantity){
		return new MapData<K,V>(genK,genV, quantity);
	}
	
	public static <K,V> MapData<K, V> map(Generator<K> genK,V v,int quantity){
		return new MapData<K,V>(genK,v, quantity);
	}
	public static <K,V> MapData<K, V> map(Iterable<K> genK,Generator<V> genV){
		return new MapData<K,V>(genK,genV);
	}
	
	public static <K,V> MapData<K, V> map(Iterable<K> genK,V v){
		return new MapData<K,V>(genK,v);
	}
	
}
