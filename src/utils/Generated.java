package utils;

import java.lang.reflect.Array;

/**
 * @author Administrator
 *
 */
public class Generated {

	/**
	 * @param arr
	 * @param gen
	 * @return
	 */
	public static <T> T[] array(T[] arr,Generator<T> gen){
		return new CollectionData<T>(gen,arr.length).toArray(arr);
	}
	
	public static <T> T[] array(Class<T> type,Generator<T> gen,int size){
		T[] aTs = (T[])Array.newInstance(type, size);
		return new CollectionData<T>(gen, size).toArray(aTs);
		
	}
	
}
