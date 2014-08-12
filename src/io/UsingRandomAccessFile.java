/**
 * 
 */
package io;

import java.io.RandomAccessFile;

/**
 * @author Administrator
 * 
 */
public class UsingRandomAccessFile {

	static String file = "F:\\poems.out";

	static void display() throws Exception {
		RandomAccessFile rAccessFile = new RandomAccessFile(file, "r");
		for (int i = 0; i < 7; i++)
			System.out.println("Value " + i + ": " + rAccessFile.readDouble());
		System.out.println(rAccessFile.readUTF());
		rAccessFile.close();
		System.out.println("------------------------");
	}

	public static void main(String[] args) throws Exception {
		RandomAccessFile rFile = new RandomAccessFile(file, "rw");
		for (int i = 0; i < 7; i++)
			rFile.writeDouble(i * 1.414);
		rFile.writeUTF("this UTF code .太好了，不会乱了吧？？？");
		rFile.close();
		display();

		rFile = new RandomAccessFile(file, "rw");
		rFile.seek(5 * 8); // 因为double总是8个字节长度。所以为了用seek()查找第五个双精度值，用8*5即可
		rFile.writeDouble(47.001);
		rFile.close();
		display();

	}

}
