/**
 * 
 */
package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author Administrator
 *
 */
public class BufferToText {

	public static final int BSIZE = 1024;
	
	public static void main(String[] args) throws Exception {
		FileChannel  fc = new FileOutputStream("F:\\bak_opt.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some texte 正确的人".getBytes()));
		fc.close();
		fc = new FileInputStream("F:\\opt.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		fc.read(buffer);
		buffer.flip();
		//Doesn't work
		System.out.println(buffer.asCharBuffer());
		// Decode using this system's default Charset
		buffer.rewind();
		String encoding = System.getProperty("file.encoding");
		System.out.println("Decoded using "+encoding +":"+Charset.forName(encoding).decode(buffer));
		
		//Or, we could decode with something that will print
		fc = new FileOutputStream("F:\\bak_opt2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text and some chinese 正确的人".getBytes("UTF-8")));
		fc.close();
		// Now try reading it again
		fc = new FileInputStream("F:\\bak_opt2.txt").getChannel();
		buffer.clear();
		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer());
		
		fc = new FileOutputStream("F:\\bak_opt2.txt").getChannel();
		buffer = ByteBuffer.allocate(24);
		buffer.asCharBuffer().put("And some other text");
		fc.write(buffer);
		fc.close();
		
		fc = new FileInputStream("F:\\bak_opt.txt").getChannel();
		buffer.clear();
		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer());
		
	}
}
