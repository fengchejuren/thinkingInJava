/**
 * 
 */
package enumerated.menu;

/**enum类型实现了Food接口，所有的实现了Food接口的enum实例都是Food类型
 * @author Administrator
 *
 */
public interface Food {

	enum Appetizer implements Food{
		SALAD,SOUP,SPRING_FOODS
	}
	enum MainCourse implements Food{
		LASAGNE, BURSOBU, PAD_THAI, LENTINUS, HUMMOUS, VANDOLUU
	}
	enum Dessert implements Food{
		TIRAM, GETHERTY, BOTTLE_WATER_GOODS, HOTTING, MATTING, BEGGODS
	}
	enum Coffee implements Food{
		BIRD_COFFEE, BLACK_COFFEE, HELLAND, MOSSICO_COFFEE, CATWASTECOFFEE
	}
	
	
}
