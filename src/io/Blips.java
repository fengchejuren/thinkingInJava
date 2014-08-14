/**
 * 
 */
package io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Blip1 implements Externalizable{

	public Blip1(){
		System.out.println("Blip1 constructor...");
	}
	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("Blip1.readExternal...");
		
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip1.writeExternal...");
		
	}
	
}


class Blip2 implements Externalizable{
	
	Blip2(){
		System.out.println("Blip2 constructor...");
	}
	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException,
	ClassNotFoundException {
		System.out.println("Blip2.readExternal...");
		
	}
	
	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip2.writeExternal...");
		
	}
	
}




/** Externalizable 可以对序列化进行控制，也就是说它允许控制某些类不能序列化，与 Serializable 不同的是，
 * 继承 Externalizable 的类，反序列化的时候，需要调用该类的默认的无参的构造方法
 * 而继承 Serializable 的类，反序列化的时候，完全以它存储的二进制文件来构造，不会调用构造器
 * @author Administrator
 *
 */
public class Blips {

	public static void main(String[] args) throws Exception {
		System.out.println("constructing Objects....");
		Blip1 blip1 = new Blip1();
		Blip2 blip2 = new Blip2();
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
		System.out.println("saving objects....");
		o.writeObject(blip1);
		o.writeObject(blip2);
		o.close();
		
		// now get them back
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
		System.out.println("recovering Blip1....");
		Blip1 inBlip1 = (Blip1) in.readObject();
		/*the follow option will throw an InvalidClassException except that
		 you change the Blip2's constructor to public*/
//		Blip2 inBlip2 = (Blip2) in.readObject();	
		
	}
	
	
}
