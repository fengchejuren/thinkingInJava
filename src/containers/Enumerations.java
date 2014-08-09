/**  
 * @Title: Enumerations.java 
 * @Package containers 
 * @Description: TODO 
 * @author Rock King 2014年8月9日 下午4:44:08
 * @version V1.0  
 */ 
package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import utils.Countries;

/** 
 * @Description: TODO
 * @author Rock King 2014年8月9日 下午4:44:08 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class Enumerations {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(Countries.names(10));
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements())
			System.out.print(e.nextElement()+", ");
		System.out.println();
		e = Collections.enumeration(new ArrayList<String>());
		System.out.println(e);
	}
}
