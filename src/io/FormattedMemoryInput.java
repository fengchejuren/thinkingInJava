/**
 * 
 */
package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

/**
 * @author Administrator
 * 
 */
public class FormattedMemoryInput {

	/**DataInputStream 读取中文乱码，目前还不知道怎么设置编码方式
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(
				BufferedInputFile.read("F:\\poems.txt").getBytes()));
		//in.available--在没有阻塞的情况下所能读取的字节数。当为0时，说明文件已经读取完毕
		while(in.available()!=0)
			System.out.print((char)in.readByte());

	}

}
