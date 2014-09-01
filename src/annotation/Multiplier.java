/**
 * 
 */
package annotation;


/**第20章 20.3使用apt处理注解
 * 搞不懂这个使用apt处理注解到底是怎么运行的
 * @author Administrator
 *
 */
@ExtractInterface(value="IMultiplier")
public class Multiplier {

	public int multily(int x,int y){
		int total=0;
		for(int i=0;i<x;i++){
			total = add(total,y);
		}
		return total;
	}

	/**
	 * @param total
	 * @param y
	 */
	private int add(int total, int y) {
		return total+y;
	}
	
	public static void main(String[] args) {
		Multiplier multiplier = new Multiplier();
		System.out.println("11*16 = "+multiplier.multily(11, 15));
	}
}
