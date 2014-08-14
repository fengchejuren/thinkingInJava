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

/**部分序列化对象完整案例  Externalizable
 * @author Administrator
 *
 */
public class Blip3 implements Externalizable {

	private int i;
	private String s;
	/**
	 * 
	 */
	public Blip3() {
		System.out.println("Blip3 constructor...");
	}
	
	public Blip3(String s,int i) {
		System.out.println("Blip3 constructor : int "+i+", String "+s);;
		this.i = i;
		this.s = s;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return s+i;
	}
	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("Blip3 readExternal...");
		//  You must do this
		s = (String) in.readObject();
		i = in.readInt();
		
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip3 writeExternal...");
		out.writeObject(s);
		out.writeInt(i);
		
	}

	
	/**反序列化的时候，s和i都在有参数的构造器中初始化。而s和i的值都是在readExternal（）方法中赋值的
	 * 所以可以通过readExternal（）的赋值运算，控制恢复类时对类的属性可以选择恢复或者不恢复
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Blip3 create...");
		Blip3 blip3 = new Blip3("A String",47);
		System.out.println(blip3);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
		System.out.println("Saving Blip3------");
		out.writeObject(blip3);
		out.close();
		
		System.out.println("begin to read it......");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
		Blip3 blip32 = (Blip3) in.readObject();
		System.out.println(blip32);
		in.close();
		
		
	}
	
	
}
