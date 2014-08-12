/**
 * 
 */
package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author Administrator
 * 
 */
public class BasicFileOutput {

	static String file = "F:\\poems.out";

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new StringReader(
				BufferedInputFile.read("F:\\poems.txt")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				file)));
		int lineCount = 1;
		String s;
		while((s=in.readLine())!=null)
			out.println(lineCount++ +" : "+s);
		out.close();
		//in.close();
		System.out.println("=----------------");
		System.out.print(BufferedInputFile.read(file));
	}

}
