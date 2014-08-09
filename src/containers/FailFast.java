/**  
 * @Title: FailFast.java 
 * @Package containers 
 * @Description: TODO 
 * @author Rock King 2014年8月9日 上午11:06:08
 * @version V1.0  
 */ 
package containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/** java容器有一种保护机制,可以防止多个进程同时修改同一个容器,抛出 ConcurrentModification异常
 * 这就是快速报错机制
 * @Description: TODO
 * @author Rock King 2014年8月9日 上午11:06:08 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class FailFast {

	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		Iterator<String> iterator = c.iterator();
		c.add("an　Object");
		try {
			//在容器取得迭代器之后,有增加了一个元素.可能导致容器的状态不一样
			//正确的做法是修改完容器之后,再取迭代器
			String string = iterator.next();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
