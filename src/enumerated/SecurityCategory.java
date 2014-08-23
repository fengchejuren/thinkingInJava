/**  
 * @Title: SecurityCategory.java 
 * @Package enumerated 
 * @Description: TODO 
 * @author Rock King 2014年8月23日 上午10:03:18
 * @version V1.0  
 */ 
package enumerated;

import utils.Enums;


/** 
 * @Description: TODO
 * @author Rock King 2014年8月23日 上午10:03:18 
 * @see ~!^ Keep bugs away and code with U!	 
 */

enum SecurityCategory {
	STOCK(Security.STOCK.class),BOND(Security.BOND.class);
	
	Security[] values;
	SecurityCategory(Class<? extends Security> kind){
		values = kind.getEnumConstants();
	}
	interface Security{
		enum STOCK implements Security{
			SHORT,LONG,MARGIN
		}
		enum BOND implements Security{
			MUNICIPAL,JUNK
		}
	}
	
	public Security randomSelection(){
		return Enums.random(values);
	}
	
	public static void main(String[] args) {

		for(int i=0;i<10;i++){
			SecurityCategory category = Enums.random(SecurityCategory.class);
			System.out.println(category+" : "+category.randomSelection());
		}
		
	}
	
	
}
