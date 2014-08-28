/**  
 * @Title: ConstantSpecificMethod.java 
 * @Package enumerated 
 * @Description: TODO 
 * @author Rock King 2014年8月28日 下午11:11:26
 * @version V1.0  
 */ 
package enumerated;

import java.text.DateFormat;
import java.util.Date;

/** 
 * @Description: TODO
 * @author Rock King 2014年8月28日 下午11:11:26 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public enum ConstantSpecificMethod {

	DATE_TIME{
		String getInfo(){
			return DateFormat.getDateInstance().format(new Date());
		}
	},
	CLASSPATH{
		String getInfo(){
			return System.getenv("CLASSPATH");
		}
	},
	VERSION{
		String getInfo(){
			return System.getProperty("java.version");
		}
	};
	abstract String getInfo();
	
	public static void main(String[] args) {
		for(ConstantSpecificMethod csm:values()){
			System.out.println(csm.getInfo());
		}
		
	}
}
