/**
 * 
 */
package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author Administrator
 * 
 */
public class MappedIO {

	private static int numOfInts = 4000000;
	private static int numOfUbuffInts = 4000000;

	private abstract static class Tester {
		private String name;

		public Tester(String name) {
			this.name = name;
		}

		public void runTester() {
			System.out.print(name + " : ");
			try {
				long start = System.nanoTime();
				test();
				double duration = System.nanoTime() - start;
				System.out.format("%.2f\n", duration / 1.0e9);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		public abstract void test() throws IOException;
	}

	private static Tester[] testers = { new Tester("Stream write") {

		@Override
		public void test() throws IOException {
			DataOutputStream dos = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(new File(
							"temp.temp"))));
			for (int i = 0; i < numOfInts; i++)
				dos.writeInt(i);
			dos.close();
		}
	}, new Tester("Mapped write") {

		@Override
		public void test() throws IOException {
			FileChannel fileChannel = new RandomAccessFile("temp.temp", "rw")
					.getChannel();
			IntBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,
					0, fileChannel.size()).asIntBuffer();
			for (int i = 0; i < numOfInts; i++)
				buffer.put(i);
			fileChannel.close();
		}
	}, new Tester("Stream read") {

		@Override
		public void test() throws IOException {
			DataInputStream data = new DataInputStream(new BufferedInputStream(
					new FileInputStream("temp.temp")));
			for(int i=0;i<numOfInts;i++)
				data.readInt();
			data.close();
		}

	},new Tester("Mapped read"){

		@Override
		public void test() throws IOException {
			FileChannel fc = new FileInputStream(new File("temp.temp")).getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY,0,fc.size()).asIntBuffer();
			while(ib.hasRemaining())
				ib.get();
			fc.close();
		}}, new Tester("Stream read/write"){

			@Override
			public void test() throws IOException {
				RandomAccessFile ranFile = new RandomAccessFile("temp.temp", "rw");
				ranFile.writeInt(1);
				for(int i=0;i<numOfUbuffInts;i++){
					ranFile.seek(ranFile.length()-4);
					ranFile.writeInt(ranFile.readInt());
				}
				ranFile.close();	
			}}, new Tester("Mapped read/write"){

				@Override
				public void test() throws IOException {
					FileChannel fc = new RandomAccessFile("temp.temp", "rw").getChannel();
					IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE,0,fc.size()).asIntBuffer();
					ib.put(0);
					for(int i=1;i<numOfUbuffInts;i++)
						ib.put(ib.get(i-1));
					fc.close();
				}}

	};

	public static void main(String[] args) {
		for (Tester tester : testers)
			tester.runTester();
	}
}