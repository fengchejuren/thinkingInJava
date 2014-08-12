/**  
 * @Title: OSExcute.java 
 * @Package utils 
 * @Description: TODO 
 * @author Rock King 2014年8月12日 下午11:25:45
 * @version V1.0  
 */ 
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * @Description: TODO
 * @author Rock King 2014年8月12日 下午11:25:45 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class OSExecute {

	public static void command(String command){
		boolean err = false;
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();
			BufferedReader result = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while((s=result.readLine())!=null)
				System.out.println(s);
			BufferedReader errs = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while((s=errs.readLine())!=null){
				err = true;
				System.out.println(s);
			}
		} catch (IOException e) {
			if(!command.startsWith("CMD /C"))
				command("CMD /C"+command);
			else
				throw new RuntimeException(e);
		}
		if(err)
			throw new OSExecuteException("Errors execute: "+command);
	}
	
	
	
	
	
	
	
}
