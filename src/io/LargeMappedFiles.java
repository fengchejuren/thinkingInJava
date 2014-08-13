/**
 * 
 */
package io;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 因为文件太大，不能直接放入内存，可以通过内存映射文件来解决
 * 
 * @author Administrator
 * 
 */
public class LargeMappedFiles {

	static int length = 0X8FFFFFF; // 128M

	public static void main(String[] args) throws Exception {
		MappedByteBuffer out = new RandomAccessFile("large.txt", "rw")
				.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
		for(int i=0;i<length;i++)
			out.put((byte)'x');
		System.out.println("finished writing");
		for(int i=length/2;i<length/2+6;i++)
			System.out.print(" position"+i+" -->"+(char)out.get(i));
		
	}

}
