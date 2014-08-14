/**  
 * @Title: LockingMappedFiles.java 
 * @Package io 
 * @Description: TODO 
 * @author Rock King 2014年8月13日 下午11:54:11
 * @version V1.0  
 */ 
package io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/** 
 * @Description: 对映射文件的部分加锁
 * @author Rock King 2014年8月13日 下午11:54:11 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class LockingMappedFiles {

	static final int LENGTH = 0X8FFFFFF;
	static FileChannel fc;
	
	public static void main(String[] args) throws Exception {
		
		fc = new RandomAccessFile("D:\\BigDat.txt", "rw").getChannel();
		MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
		for(int i=0;i<LENGTH;i++)
			out.put((byte)'x');
		
		new LockAndModify(out, 0, 0+LENGTH/3);
		new LockAndModify(out, LENGTH/2, LENGTH/2+LENGTH/4);
		
		
		
	}
	
	
	private static class LockAndModify extends Thread{
		private ByteBuffer buffer;
		private int start,end;
		
		/** 
		 * <p>Title: </p> 
		 * <p>Description: </p>  
		 */
		LockAndModify(ByteBuffer mbb,int start,int end) {
			this.start = start;
			this.end = end;
			mbb.limit(end);
			mbb.position(start);
			buffer = mbb.slice();
			start();
		}
		
		/* (非 Javadoc) 
		 * <p>Title: run</p> 
		 * <p>Description: </p>  
		 * @see java.lang.Thread#run() 
		 */ 
		@Override
		public void run() {
			try {
				FileLock fl = fc.lock(start,end,false);
				System.out.println("locked from "+start+" to "+end);
				//perform modify
				while(buffer.position()<buffer.limit()-1)
					buffer.put((byte)(buffer.get()+1));
				TimeUnit.MILLISECONDS.sleep(10000);
				fl.release();
				System.out.println("Released from "+start+" to "+end);
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
	}
	
}
