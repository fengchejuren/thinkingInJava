package containers;

import holding.MapOfList;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import typeInfo.pets.Individual;
import typeInfo.pets.Pet;

/** 
 * @Description: TODO
 * @author Rock King 2014年8月8日 上午12:52:07 
 * ~!^ Keep bugs away and code with U!	 
 */ 
public class IndivialTest {

	public static void main(String[] args) {
		
		Set<Individual> pets = new TreeSet<Individual>();
		for(List<?extends Pet> lp:MapOfList.petPeople.values()){
			for(Pet p:lp){
				pets.add(p);
			}
		}
		System.out.println(pets);
		
	}
}
