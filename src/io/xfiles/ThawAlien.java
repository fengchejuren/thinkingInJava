/**
 * 
 */
package io.xfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**try to recover a serialized file without the class of object that's stored in that file
 * @author Administrator
 *
 */
public class ThawAlien {

	public static void main(String[] args) throws Exception{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(".", "X.file")));
		Object myobj = in.readObject();
		System.out.println(myobj.getClass());
	}
}
