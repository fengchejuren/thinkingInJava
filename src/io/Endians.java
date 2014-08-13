/**
 * 
 */
package io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**字节存放次序：不同的机器可能有不同的字节排序方法来存放数据
 * 高位优先（big Endians）将重要的字节存放在低位的存储空间内
 * 低位优先（little Endians）将重要的字节存放在高位的存储空间内
 * ByteBuffer是以高位优先的顺序存储数据的
 * @author Administrator
 *
 */
public class Endians {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[12]);
		buffer.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(buffer.array()));
		buffer.rewind();
		
		buffer.order(ByteOrder.BIG_ENDIAN);
		buffer.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(buffer.array()));
		buffer.rewind();
		
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(buffer.array()));
		buffer.rewind();
		
	}
	
	
	
}
