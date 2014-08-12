/**  
 * @Title: TransferTo.java 
 * @Package io 
 * @Description: TODO 
 * @author Rock King 2014年8月13日 上午1:17:03
 * @version V1.0  
 */ 
package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/** 
 * @Description: TODO
 * @author Rock King 2014年8月13日 上午1:17:03 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class TransferTo {

	public static void main(String[] args) throws Exception{
		if(args.length!=2){
			System.out.println("arguments sourcefile destfile ");
			System.exit(1);
		}
		FileChannel in = new FileInputStream(args[0]).getChannel(),
				out = new FileOutputStream(args[1]).getChannel();
		in.transferTo(0, in.size(), out);
		// Or
		//out.transferFrom(in, 0, in.size());
	}
	
	
	
}
