/**
 * 
 */
package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/**ByteBuffer通过一个被包装的8字节数组产生，然后通过不同的基本类型的视图缓冲器显示出来。
 * ----------------------------------------------------------------------
 * bytes    |0	|	0	|	0	|	0	|	0	|	0	|	0	|	97|
 * chars	|			|				|				|		a	  |
 * shorts	|	0		|		0		|		0		|		97	  |
 * ints		|			0				|				97			  |
 * floats	|			0.0				|			1.36E-43		  |
 * longs	|							97							  |
 * doubles	|							4.8E-332					  |
 * ----------------------------------------------------------------------
 * @author Administrator
 *
 */
public class ViewBuffers {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});
		buffer.rewind();
		System.out.println("ByteBuffer ");
		while(buffer.hasRemaining())
			System.out.print(buffer.position()+"-->"+buffer.get()+"   ");
		System.out.println();
		
		CharBuffer charBuffer = ((ByteBuffer)buffer.rewind()).asCharBuffer();
		System.out.println("charBuffer ");
		while(charBuffer.hasRemaining())
			System.out.print(charBuffer.position()+"-->"+charBuffer.get()+"   ");
		System.out.println();
		
		FloatBuffer floatBuffer = ((ByteBuffer)buffer.rewind()).asFloatBuffer();
		System.out.println("floatBuffer ");
		while(floatBuffer.hasRemaining())
			System.out.print(floatBuffer.position()+"-->"+floatBuffer.get()+"   ");
		System.out.println();
		
		IntBuffer intBuffer = ((ByteBuffer)buffer.rewind()).asIntBuffer();
		System.out.println("intBuffer ");
		while(intBuffer.hasRemaining())
			System.out.print(intBuffer.position()+"-->"+intBuffer.get()+"   ");
		System.out.println();
		
		LongBuffer longBuffer = ((ByteBuffer)buffer.rewind()).asLongBuffer();
		System.out.println("longBuffer ");
		while(longBuffer.hasRemaining())
			System.out.print(longBuffer.position()+"-->"+longBuffer.get()+"   ");
		System.out.println();
		
		ShortBuffer shortBuffer = ((ByteBuffer)buffer.rewind()).asShortBuffer();
		System.out.println("shortBuffer");
		while(shortBuffer.hasRemaining())
			System.out.print(shortBuffer.position()+"-->"+shortBuffer.get()+"   ");
		System.out.println();
		
		DoubleBuffer doubleBuffer = ((ByteBuffer)buffer.rewind()).asDoubleBuffer();
		System.out.println("doubleBuffer");
		while(doubleBuffer.hasRemaining())
			System.out.print(doubleBuffer.position()+"-->"+doubleBuffer.get()+"   ");
		System.out.println();
		
		
	}
}
