/**  
 * @Title: People.java 
 * @Package io.xml 
 * @Description: TODO 
 * @author Rock King 2014年8月16日 上午9:14:53
 * @version V1.0  
 */ 
package io.xml;

import java.util.ArrayList;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

/** 
 * @Description: TODO
 * @author Rock King 2014年8月16日 上午9:14:53 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class People extends ArrayList<Person> {

	public People(String fileName) throws Exception{
		Document document = new Builder().build(fileName);
		Elements elements = document.getRootElement().getChildElements();
		for(int i=0;i<elements.size();i++)
			add(new Person(elements.get(i)));
	}
	
	
	public static void main(String[] args) throws Exception {
		People people = new People("people.xml");
		System.out.println(people);
	}
	
	
}
