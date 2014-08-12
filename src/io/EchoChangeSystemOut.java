/**
 * 
 */
package io;

import java.io.PrintWriter;

/**
 * @author Administrator
 *
 */
public class EchoChangeSystemOut {

	
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		out.print("hello world!!");
		out.close();
	}
	
	
}
