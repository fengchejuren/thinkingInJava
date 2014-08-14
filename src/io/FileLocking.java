/**  
 * @Title: FileLock.java 
 * @Package io 
 * @Description: TODO 
 * @author Rock King 2014年8月13日 下午10:51:36
 * @version V1.0  
 */ 
package io;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/** 文件加锁机制:允许我们同步访问某个作为共享资源的文件
 * 不过,竞争同一文件的进程可能不在同一个Java虚拟机上,或者一个是Java线程,另外一个是操作系统的其他进程.
 * 因此Java的文件加锁直接映射到本地操作系统的加锁工具
 * @Description: TODO
 * @author Rock King 2014年8月13日 下午10:51:36 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class FileLocking {

	public static void main(String[] args) throws Exception {
		FileOutputStream out = new FileOutputStream("D:\\opt.txt");
		FileLock lock = out.getChannel().tryLock();
		//或者 FileLock lock = out.getChannel().lock();两者的区别是tryLock()是非阻塞式的,如果以前有其他的线程锁定了
		// 文件,tryLock()返还为空.而lock()则是阻塞式的,它会一直等待直到获得锁,或者lock的线程中断,或者调用lock的通道关闭
		System.out.println("是否是独占锁:"+lock.isShared());
		if(lock!=null){
			System.out.println("Locked file:");
			TimeUnit.MILLISECONDS.sleep(10000);
			lock.release();
			System.out.println("release file");
		}
		out.close();
		
	}
	
	
	
}
