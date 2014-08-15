/**  
 * @Title: MyWorld.java 
 * @Package io 
 * @Description: TODO 
 * @author Rock King 2014年8月14日 下午10:58:59
 * @version V1.0  
 */
package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class House implements Serializable {
}

class Animal implements Serializable {
	private String name;
	private House preferedHouse;

	Animal(String name, House house) {
		this.name = name;
		this.preferedHouse = house;
	}

	/*
	 * (非 Javadoc) <p>Title: toString</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + "[ " + super.toString() + " ]," + preferedHouse + "\n";
	}
}

/**通过一个字节数组来使用对象序列化，从而实现任何可序列化的对象深度复制（deep copy）.
 * 深度复制意味着我们复制的整个对象网，而不是基本对象及其引用
 * @Description: TODO
 * @author Rock King 2014年8月14日 下午10:58:59
 * @see ~!^ Keep bugs away and code with U!
 */

public class MyWorld {

	/** 将 animals两次序列化，送至不同的流。可以看到两次序列化指向了相同的地址，
	 * 包括共享的House的引用，也是指向同一个地址
	 * @Description: TODO 
	 * @param args
	 * @throws Exception   
	 * void  
	 * @throws 
	 * @see Any changes please send mail to:superman166@126.com  
	 * ~!^ Keep bugs away and code with U!	
	 */
	public static void main(String[] args) throws Exception {
		House house = new House();
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Dog Brother", house));
		animals.add(new Animal("Cat sister", house));
		animals.add(new Animal("Duck Brother", house));
		animals.add(new Animal("Tiger Brother", house));
		System.out.println("animals: " + animals);

		ByteArrayOutputStream buff1 = new ByteArrayOutputStream();
		ObjectOutputStream out1 = new ObjectOutputStream(buff1);
		out1.writeObject(animals);
		out1.writeObject(animals); // write a second set 第二次写入
		// write to a different stream
		ByteArrayOutputStream buff2 = new ByteArrayOutputStream();
		ObjectOutputStream out2 = new ObjectOutputStream(buff2);
		out2.writeObject(animals);

		// now get them back
		ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(
				buff1.toByteArray()));
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(
				buff2.toByteArray()));
		
		List animals1 = (List) in1.readObject(),
		animals2 = (List) in1.readObject(),
		animals3 = (List) in2.readObject();
		
		System.out.println("animals1:---------\n"+animals1);
		System.out.println("animals2:---------\n"+animals2);
		System.out.println("animals3:---------\n"+animals3);

	}

}
