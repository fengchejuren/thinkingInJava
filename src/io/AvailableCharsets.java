/**
 * 
 */
package io;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * @author Administrator
 *
 */
public class AvailableCharsets {
	
	public static void main(String[] args) {
		SortedMap<String, Charset> charsets = Charset.availableCharsets();
		Iterator<String> iterator = charsets.keySet().iterator();
		while(iterator.hasNext()){
			String csname = iterator.next();
			System.out.print(csname+" ");
			Iterator<String> iterator2 = charsets.get(csname).aliases().iterator();
			if(iterator2.hasNext())
				System.out.print(": ");
			while(iterator2.hasNext()){
				System.out.print(iterator2.next());
				if(iterator2.hasNext())
					System.out.print(" , ");
			}
			System.out.println();
		}
	}
	
	

}
