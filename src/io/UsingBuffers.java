/**
 * 
 */
package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author Administrator
 *
 */
public class UsingBuffers {

	/**交换相邻两个字符的位置
	 * @param buffer
	 */
	public static void symmetricScrample(CharBuffer buffer){
		while(buffer.hasRemaining()){
			buffer.mark();
			char c1 = buffer.get();
			char c2 = buffer.get();
			buffer.reset();
			buffer.put(c2).put(c1);		//交换两个字符型的数据的变量，也可以写成    buffer.put(c2);buffer.put(c1);
		}
		
	}
	
	public static void main(String[] args) {
		char[] data = "Using buffers to get some interestings".toCharArray();
		ByteBuffer buffer = ByteBuffer.allocate(data.length*2);
		CharBuffer charBuffer = buffer.asCharBuffer();
		charBuffer.put(data);
		System.out.println("charBuffer.rewind--- "+charBuffer.rewind());

		symmetricScrample(charBuffer);
		System.out.println(charBuffer.rewind());
		
		symmetricScrample(charBuffer);
		System.out.println(charBuffer.rewind());
		
	}
	
}
