/**  
 * @Title: ChannelCopy.java 
 * @Package io 
 * @Description: TODO 
 * @author Rock King 2014年8月13日 上午12:33:30
 * @version V1.0  
 */ 
package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/** 
 * @Description: TODO
 * @author Rock King 2014年8月13日 上午12:33:30 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class ChannelCopy {

	private static final int BSIZE = 1024;
	
	public static void main(String[] args) throws Exception {
		if(args.length!=2){
			System.out.println("argument : sourceFile destfile");
			System.exit(1);
		}
		FileChannel in = new FileInputStream(args[0]).getChannel(),
				out = new FileOutputStream(args[1]).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while(in.read(buffer)!=-1){
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}
		
	}
	
	
	
}
