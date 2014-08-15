/**
 * 
 */
package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class RecoverCADState {

	public static void main(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
		List<Class<? extends Shape>> shapeType = (List<Class<? extends Shape>>) in.readObject();
		Line.deSerializeStaticState(in);
		List<Shape> shapes = (List<Shape>) in.readObject();
		System.out.println(shapes);
		
	}
	
}
