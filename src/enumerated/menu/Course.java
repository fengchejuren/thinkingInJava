/**
 * 
 */
package enumerated.menu;

import utils.Enums;

/**
 * @author Administrator
 *
 */
public enum Course {

	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCourse.class),
	DESSERT(Food.Dessert.class),
	COFFEE(Food.Coffee.class);
	
	private Food[] course;
	
	private Course(Class<? extends Food> foodClass){
		this.course = foodClass.getEnumConstants();
	}
	
	public Food randomSelection(){
		return Enums.random(course);
	}
}
