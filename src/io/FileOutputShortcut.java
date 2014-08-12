/**
 * 
 */
package io;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author Administrator
 * 
 */
public class FileOutputShortcut {

	static String file = "F:\\poems.out";

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new StringReader(
				BufferedInputFile.read("F:\\poems.txt")));
		PrintWriter out = new PrintWriter(file);
		int lineCount = 1;
		String s;
		while((s=in.readLine())!=null)
			out.println(lineCount+" : " +s);
		out.close();
	}

}
