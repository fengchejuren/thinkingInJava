/**
 * 
 */
package annotation;

import atunit.Test;

/**
 * @author Administrator
 *
 */
public class Testable {

	public void execute(){
		System.out.println("Execute...");
	}
	
	@Test void testExecute(){execute();}
	
	
}
