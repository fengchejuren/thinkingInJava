package containers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import utils.Countries;

public class Lists {

	private static boolean b;
	private static int i;
	private static String s;
	private static Iterator<String> it;
	private static ListIterator<String> lit;
	
	/**每个list都可以执行的操作
	 * @param a
	 */
	public static void basicTest(List<String> a){
		a.add(1, "X"); // add at location 1
		a.add("x"); // add at end
		a.addAll(Countries.names(25));
		a.addAll(3, Countries.names(25));
		b = a.contains(1);
		b = a.containsAll(Countries.names(25));
		s = a.get(1);
		i = a.indexOf("1");
		b = a.isEmpty();
		it = a.iterator();
		lit = a.listIterator();
		lit = a.listIterator(3);
		i = a.lastIndexOf("1");
		a.remove(1);
		a.remove("3");
		a.set(1, "y");
		a.retainAll(Countries.names(25));
		a.removeAll(Countries.names(25));
		i = a.size();
		a.clear();

	}
	
	/**使用iterator 遍历元素
	 * @param a
	 */
	public static void iterMotion(List<String> a){
		ListIterator<String> it = a.listIterator();
		b = it.hasNext();
		b = it.hasPrevious();
		s = it.next();
		i = it.nextIndex();
		s = it.previous();
		i = it.previousIndex();
	}
	
	/**使用iterator 修改元素
	 * @param a
	 */
	public static void iterManipulation(List<String> a){
		ListIterator<String> it = a.listIterator();
		it.add("47");
		//must move to an element after add()
		it.next();
		//Remove the element after the newly produced one
		it.remove();
		//must move to an element after remove()
		it.next();
		//change the element after delete
		it.set("47");
	}
	
	/**查看List 的操作效果
	 * @param a
	 */
	public static void testVisual(List<String> a){
		System.out.println(a);
		List<String> b = Countries.names(25);
		System.out.println("b:"+b);
		a.addAll(b);
		a.addAll(b);
		System.out.println(a);
		ListIterator<String> x = a.listIterator(a.size()/2);
		x.add("one");
		System.out.println(a);
		System.out.println(x.next());
		x.remove();
		System.out.println(x.next());
		x.set("47");
		System.out.println(a);
		//Traverse the list backwards
		x = a.listIterator(a.size());
		while(x.hasPrevious()){
			System.out.print(x.previous()+"		");
		}
		System.out.println("------------testVisual finished------------------");
	}
	
	/**
	 * somethings that only linkedList can do
	 */
	public static void testLinkedList(){
		LinkedList<String> l1 = new LinkedList<String>();
		l1.addAll(Countries.names(25));
		System.out.println(l1);
		//treat it like stack,push
		l1.addFirst("first");
		l1.addFirst("second");
		System.out.println(l1);
		//like "peeking" at the top of a stack
		System.out.println(l1.getFirst());
		//like "poping" a stack
		System.out.println(l1.removeFirst());
		System.out.println(l1.removeFirst());
		//treat it like a Queue,pulling elements off the trail end
		System.out.println(l1.removeLast());
		System.out.println(l1);
		
	}
	
	public static void main(String[] args) {
		basicTest(new LinkedList<String>(Countries.names(25)));
		basicTest(new ArrayList<String>(Countries.names(25)));
		iterMotion(new LinkedList<String>(Countries.names(25)));
		iterMotion(new ArrayList<String>(Countries.names(25)));
		iterManipulation(new LinkedList<String>(Countries.names(25)));
		iterManipulation(new ArrayList<String>(Countries.names(25)));
		testVisual(new LinkedList<String>(Countries.names(25)));
		testLinkedList();
		
		
	}
}
