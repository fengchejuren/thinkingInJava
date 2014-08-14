/**
 * 
 */
package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 如果不想实现接口Externalizable，除了用transient修饰不想被序列化的属性以外，也可以用下面的方法 实现 Serializable
 * 接口，然后在类中 添加 readObject()和writeObject()方法
 * 注意readObject()和writeObject()这两个方法是ObjectOutputStream和ObjectInputStream类调用的
 * 。方法签名不能有丝毫的错误
 * 
 * @author Administrator
 * 
 */
public class SerialCtl implements Serializable {

	private String a;
	private transient String b;

	public SerialCtl(String aa, String bb) {
		a = "Not Transient " + aa;
		b = "Transient " + bb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return a + "  " + b;
	}

	/**
	 * 如果我们打算用默认的机制读取对象的 非Transient部分的属性，则必须调用defaultReadObject()方法
	 * 同样写入对象的非Transient部分的属性，则必须调用defaultWriteObject()方法
	 * 
	 * @param stream
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		stream.writeObject(b);
	}

	/**
	 * 如果我们打算用默认的机制读取对象的 非Transient部分的属性，则必须调用defaultReadObject()方法
	 * 同样写入对象的非Transient部分的属性，则必须调用defaultWriteObject()方法
	 * 
	 * @param stream
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void readObject(ObjectInputStream stream)
			throws ClassNotFoundException, IOException {
		stream.defaultReadObject();
		b = (String) stream.readObject();
	}

	public static void main(String[] args) throws Exception {
		SerialCtl sc = new SerialCtl("test1", "test2");
		System.out.println("Before SerialCtl=" + sc);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(buf);
		o.writeObject(sc);

		// get It
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(
				buf.toByteArray()));
		SerialCtl sc2 = (SerialCtl) in.readObject();
		System.out.println("After SerialCtl=" + sc2);

	}

}
