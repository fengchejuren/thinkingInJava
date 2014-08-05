package utils;

import java.util.ArrayList;

/** 
 * @Description: TODO
 * @author Rock King 2014年8月5日 下午11:05:16 
 * ~!^ Keep bugs away and code with U!	
 * @param <T> 
 */ 
public class CollectionData<T> extends ArrayList<T> {
	public CollectionData(Generator<T> generator,int quantity){
		for(int i=0;i<quantity;i++){
			add(generator.next());
		}
	}
	
	public static <T> CollectionData<T> list(Generator<T> generator,int quantity){
		return new CollectionData<>(generator, quantity);
		
	}

}
