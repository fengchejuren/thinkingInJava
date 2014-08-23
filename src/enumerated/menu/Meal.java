/**  
 * @Title: Meal.java 
 * @Package enumerated.menu 
 * @Description: TODO 
 * @author Rock King 2014年8月23日 上午9:58:25
 * @version V1.0  
 */ 
package enumerated.menu;

/** 
 * @Description: TODO
 * @author Rock King 2014年8月23日 上午9:58:25 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class Meal {

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			for(Course c:Course.values()){
				Food food = c.randomSelection();
				System.out.println(food);
			}
			System.out.println("------这是第"+i+"个元素----------");
		}
		
	}
}
