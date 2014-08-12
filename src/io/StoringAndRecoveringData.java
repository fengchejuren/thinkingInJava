/**
 * 
 */
package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Administrator
 * 
 */
public class StoringAndRecoveringData {

	public static void main(String[] args) throws Exception {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream("F:\\poems.txt")));
		out.writeDouble(3.14159);
		// out.writeUTF("我是中文你相信吗？？？that was true!");
		out.writeUTF("that was PI你厉害。。。");
		out.writeDouble(3.145);
		// out.writeUTF("没有节操的下限哦oooo!");
		out.writeUTF("PI limit!");
		out.close();

		DataInputStream in = new DataInputStream(new BufferedInputStream(
				new FileInputStream("F:\\poems.txt")));
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
	}

}
