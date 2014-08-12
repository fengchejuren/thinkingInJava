/**
 * 
 */
package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Demonstrates standard I/O redirection
 * 
 * @author Administrator
 * 
 */
public class EchoRedirecting {

	public static void main(String[] args) throws Exception {
		PrintStream console = System.out;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				"F:\\poems.txt"));
		PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("F:\\poems.java")));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null)
			System.out.println(s);
		out.close();
		System.setOut(console);

	}

}
