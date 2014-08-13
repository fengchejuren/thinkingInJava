/**
 * 
 */
package io;

import java.nio.ByteBuffer;

/**
 * @author Administrator
 *
 */
public class GetData {

	private static final int BSIZE = 1024;
	
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		int i=0;
		while(i++<buffer.limit())
			if(buffer.get()!=0)
				System.out.println("nonzezo");
		System.out.println("i="+i);
		buffer.rewind();
		buffer.asCharBuffer().put("Hollywood!");
		char c;
		while((c=buffer.getChar())!=0)
			System.out.print(c+" ");
		System.out.println();
		buffer.rewind();
		
		buffer.asShortBuffer().put((short)471142);
		System.out.println(buffer.getShort());
		buffer.rewind();
		
		buffer.asIntBuffer().put(99471142);
		System.out.println(buffer.getInt());
		buffer.rewind();
		
		buffer.asLongBuffer().put(957856549565L);
		System.out.println(buffer.getLong());
		buffer.rewind();
		
		// Store and read a double
		buffer.asDoubleBuffer().put(3.15689);
		System.out.println(buffer.getDouble());
		buffer.rewind();
		
		buffer.asFloatBuffer().put((float)598.5621454522);
		System.out.println(buffer.getFloat());
		buffer.rewind();
		
	}
	
	
	
	
	
	
	
	
	
	
}
