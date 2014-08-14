/**
 * 
 */
package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**假如某个类实现了 Serializable 接口，但是序列化时又不想保存它的全部信息，那该怎么做呢？？？
 * 很简单，将不想序列化的字段标识为 transient
 * @author Administrator
 *
 */
public class Logon implements Serializable{

	private Date date = new Date();
	private String username;
	private transient String password;
	public Logon(String username, String password) {
		this.username = username;
		this.password = password;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Login Info: name="+username+" ,date = "+date+" , password="+password;
	}
	
	public static void main(String[] args) throws Exception {
		Logon a = new Logon("Hully", "myDog'sfriend");
		System.out.println("Logon a="+a);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Logon.out"));
		out.writeObject(a);
		out.close();
		TimeUnit.MILLISECONDS.sleep(10000);
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
		Logon b = (Logon) in.readObject();
		System.out.println("Logon b="+b);
	}
}
