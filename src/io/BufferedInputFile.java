package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author Administrator
 *
 */
public class BufferedInputFile {

	/**打开一个文件用于字符输入，可以使用String或者File对象作为文件名的FileInputReader.
	 * 为了提高速度，我们使用BufferedReader进行文件的缓冲
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String read(String fileName) throws Exception{
		
		BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
		String s;
		StringBuilder builder = new StringBuilder();
		while((s=in.readLine())!=null)
			builder.append(s+"\n");
		in.close();
		return builder.toString();
		
	}
	
	
	public static void main(String[] args)throws Exception {
		//System.out.print(read("F:\\js1.html"));
		System.out.print(read("F:\\img1.jpg"));
		
		
	}
	
}
