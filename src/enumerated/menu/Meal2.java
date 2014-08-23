/**  
 * @Title: Meal2.java 
 * @Package enumerated.menu 
 * @Description: TODO 
 * @author Rock King 2014年8月23日 上午10:18:06
 * @version V1.0  
 */
package enumerated.menu;

import utils.Enums;

/**
 * @Description: TODO
 * @author Rock King 2014年8月23日 上午10:18:06
 * @see ~!^ Keep bugs away and code with U!
 */

public enum Meal2 {
	APPETIZER(Food.APPETIZER.class), MAINCOURSE(Food.MAINCOURSE.class), 
	DESSERT(Food.DESSERT.class), COFFEE(Food.COFFEE.class);
	private Food[] values;
	Meal2(Class<? extends Food> types){
		values = types.getEnumConstants();
	}
	
	public interface Food{
		enum APPETIZER implements Food{
			SALAD,SOUP,SPRING_FOODS
		}
		enum MAINCOURSE implements Food{
			LASAGNE, BURSOBU, PAD_THAI, LENTINUS, HUMMOUS, VANDOLUU
		}
		enum DESSERT implements Food{
			TIRAM, GETHERTY, BOTTLE_WATER_GOODS, HOTTING, MATTING, BEGGODS
		}
		enum COFFEE implements Food{
			BIRD_COFFEE, BLACK_COFFEE, HELLAND, MOSSICO_COFFEE, CATWASTECOFFEE
		}
	}
	
	public Food randomSelection(){
		return Enums.random(values);
	}
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			for(Meal2 meal2:Meal2.values()){
				Food f = meal2.randomSelection();
				System.out.println(f);
			}
			System.out.println("-------------------------------dd");
		}
		
		
	}
	
}
