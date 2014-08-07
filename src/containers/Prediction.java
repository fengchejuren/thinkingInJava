package containers;

import java.util.Random;

/**预报，与土拨鼠建立连接
 * @author Administrator
 *
 */
public class Prediction {

	private static Random random = new Random(47);
	private boolean shadow = random.nextDouble()>0.5;
	@Override
	public String toString() {
		if(shadow){
			return "six more weeks winter!";
		}else {
			return "Early Spring!!!";
		}
	}
}
