/**
 * 
 */
package enumerated.menu;

import enumerated.menu.Food.Appetizer;
import enumerated.menu.Food.Coffee;
import enumerated.menu.Food.Dessert;
import enumerated.menu.Food.MainCourse;

/**
 * @author Administrator
 *
 */
public class TypesOfFood{

	public static void main(String[] args) {
		Food food = Appetizer.SALAD;
		food = MainCourse.LASAGNE;
		food = Dessert.HOTTING;
		food = Coffee.BIRD_COFFEE;
		
		
	}
}
