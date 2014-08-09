/**  
 * @Title: Stacks.java 
 * @Package containers 
 * @Description: TODO 
 * @author Rock King 2014年8月9日 下午4:59:46
 * @version V1.0  
 */
package containers;

import java.util.LinkedList;
import java.util.Stack;


enum MONTH {
	JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST,
		SEPTEMPER, OCTOBER, NOVEMBER, DECMBER
}

/**
 * @Description: TODO
 * @author Rock King 2014年8月9日 下午4:59:46
 * @see ~!^ Keep bugs away and code with U!
 */

public class Stacks {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		for(MONTH month:MONTH.values())
			stack.push(month.toString());
		System.out.println("Stack:\n"+stack);
		//treating as a Vector
		stack.addElement("last line");
		System.out.println("Stack:\n"+stack);
		System.out.println("element 5 ="+stack.elementAt(5));
		System.out.println("poping elements:");
		while(!stack.empty())
			System.out.print(stack.pop()+",");
		LinkedList<String> lstack = new LinkedList<String>();
		for(MONTH month:MONTH.values())
			lstack.addFirst(month.toString());
		System.out.println("lsk: \n"+lstack);
		while(!lstack.isEmpty())
			System.out.print(lstack.removeLast()+", ");
		
	}
}
