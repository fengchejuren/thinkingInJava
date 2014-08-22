/**
 * 
 */
package enumerated;

//使用static import可以将enum实例的标识符带入当前命名空间，所以无需用Spiciness来修饰Hot等Spiciness的实例
import static enumerated.Spiciness.*;
/**
 * @author Administrator
 *
 */
public class Burrito {

	Spiciness degree;
	
	public Burrito(Spiciness degree){
		this.degree = degree;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Burrito: "+degree;
	}
	
	public static void main(String[] args) {
		System.out.println(new Burrito(HOT));
		System.out.println(new Burrito(FLAMING));
		System.out.println(new Burrito(MEDIUM));
	}
}
