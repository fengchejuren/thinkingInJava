/**  
 * @Title: NotClass.java 
 * @Package enumerated 
 * @Description: TODO 
 * @author Rock King 2014年8月28日 下午11:22:02
 * @version V1.0  
 */ 
package enumerated;

enum LikeClasses{
	WINKEY{
		void behavior(){
			System.out.println("behavior1...");
		}
	},
	BLINKEY{
		void behavior(){
			System.out.println("behavior2...");
		}
	},
	NOD{
		void behavior(){
			System.out.println("behavior3...");
		}
	};
	abstract void behavior();
}
/** 
 * @Description: TODO
 * @author Rock King 2014年8月28日 下午11:22:02 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class NotClass {

}
