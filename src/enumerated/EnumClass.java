/**
 * 
 */
package enumerated;

enum Shrubbery{
	GROUND,CRAWLING,HANGING
}
/**
 * @author Administrator
 *
 */
public class EnumClass {

	public static void main(String[] args) {
		for(Shrubbery shrubbery:Shrubbery.values()){
			System.out.print(shrubbery+" ordinary:"+shrubbery.ordinal());
			System.out.print("  "+shrubbery.equals(Shrubbery.CRAWLING)+"  ");
			System.out.print("  "+shrubbery.compareTo(Shrubbery.CRAWLING));
			System.out.print("  "+(shrubbery==Shrubbery.CRAWLING));
			System.out.print("  "+shrubbery.getDeclaringClass());
			System.out.print("  "+shrubbery.name());
			System.out.println();
		}
		
	}
	
	
	
}
