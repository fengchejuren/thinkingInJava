/**
 * 
 */
package io;

import java.io.StringReader;

/**
 * @author Administrator
 *
 */
public class MemoryInput {

	public static void main(String[] args) throws Exception {
		StringReader in = new StringReader(BufferedInputFile.read("F:\\poems.txt"));
		int c;
		while((c=in.read())!=-1)
			System.out.print((char)c);
	}
}
