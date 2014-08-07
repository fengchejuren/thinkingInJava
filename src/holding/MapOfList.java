/**  
 * @Title: MapOfList.java 
 * @Package holding 
 * @Description: TODO 
 * @author Rock King 2014年8月8日 上午1:08:19
 * @version V1.0  
 */
package holding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import typeInfo.pets.Cat;
import typeInfo.pets.Cymric;
import typeInfo.pets.Dog;
import typeInfo.pets.Mutt;
import typeInfo.pets.Person;
import typeInfo.pets.Pet;
import typeInfo.pets.Put;
import typeInfo.pets.Rat;

/**
 * @Description: TODO
 * @author Rock King 2014年8月8日 上午1:28:01
 * @see ~!^ Keep bugs away and code with U!
 */
public class MapOfList {
	public static Map<Person, List<? extends Pet>> petPeople = new HashMap<Person, List<? extends Pet>>();
	static {
		petPeople.put(new Person("Dawn"),
				Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
		petPeople.put(new Person("Kate"), Arrays.asList(new Cat("Shackleton"),
				new Cat("Elsie May"), new Dog("Margerett")));
		petPeople.put(new Person("Marilny"), Arrays.asList(new Cat("Pincloy"),
				new Put("Louie aka Louis  Snorkeleste Durpee"), new Cat(
						"Standford aka Stinky El Nero")));
		petPeople.put(new Person("Luke"), Arrays.asList(new Rat("Fuzzy"),new Rat("Fizzy")));
		petPeople.put(new Person("Isaac"), Arrays.asList(new Rat("Freckly")));
	}
	
	
	public static void main(String[] args) {
		System.out.println(petPeople.keySet());
		System.out.println("pets: "+petPeople.values());
		for(Person person:petPeople.keySet()){
			System.out.println(person+"has pets:-------------------");
			for(Pet pet:petPeople.get(person)){
				System.out.print(pet+" , ");
			}
			System.out.println();
		}
	}
}
