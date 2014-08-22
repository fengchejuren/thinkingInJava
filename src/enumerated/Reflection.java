/**
 * 
 */
package enumerated;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import utils.OSExecute;

enum Explore {
	HERE, THERE
}

/**
 * @author Administrator
 * 
 */
public class Reflection {

	public static Set<String> analyze(Class<?> enumClass) {
		System.out.println("------------analyze enumClass------------------");
		System.out.println("interfaces:===");
		for (Type t : enumClass.getGenericInterfaces())
			System.out.println(t);
		System.out.println("Base:" + enumClass.getGenericSuperclass());
		System.out.println("Method:");
		Set<String> methods = new TreeSet<String>();
		for (Method method : enumClass.getMethods()) {
			methods.add(method.getName());
		}
		System.out.println(methods);
		return methods;
	}

	public static void main(String[] args) {
		Set<String> exploreMethods = analyze(Explore.class);
		Set<String> enumMethods = analyze(Enum.class);
		System.out.println("Explore contains all Enum's methods:"
				+ exploreMethods.containsAll(enumMethods));
		System.out.println("Explore remove all Enum's methods:");
		exploreMethods.removeAll(enumMethods);
		System.out.println(exploreMethods);
		OSExecute.command("javap Explore");
		
	}
}
