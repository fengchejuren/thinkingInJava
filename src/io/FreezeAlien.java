/**
 * 
 */
package io;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @author Administrator
 *
 */
public class FreezeAlien {

	public static void main(String[] args) throws Exception {
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("X.file"));
		Alien quellek = new Alien();
		out.writeObject(quellek);
		
		
	}
}
