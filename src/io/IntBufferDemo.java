/**
 * 
 */
package io;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**view buffer 视图缓冲器
 * @author Administrator
 *
 */
public class IntBufferDemo {

	private static final int BSIZE = 1024;
	
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		IntBuffer intBuffer = buffer.asIntBuffer();
		intBuffer.put(new int[]{12,57,78,120,2540,9586,(int)'a',(int)'A'});
		System.out.println(intBuffer.get(0));
		intBuffer.put(3,568);
		intBuffer.flip();
		while(intBuffer.hasRemaining())
			System.out.print(intBuffer.get()+" ");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
