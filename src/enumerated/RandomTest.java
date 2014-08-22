/**
 * 
 */
package enumerated;

import utils.Enums;

enum Activity{
	SITTING,WALKING,RUN,DODGING,JUMPING,LYING,FAILING,FLYING
}
/**
 * @author Administrator
 *
 */
public class RandomTest {

	public static void main(String[] args) {
		for(int i=0;i<20;i++)
			System.out.print(Enums.random(Activity.class)+",");
	}
}
