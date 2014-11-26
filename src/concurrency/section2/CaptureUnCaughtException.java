/**  
 * @Title: CaptureUnCaughtException.java 
 * @Package concurrency.section2 
 * @Description: TODO 
 * @author Rock King 2014年11月27日 上午12:10:37
 * @version V1.0  
 */ 
package concurrency.section2;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月27日 上午12:10:37 
 * @see ~!^ Keep bugs away and code with U!	 
 */
class ExceptionThread2 implements Runnable{

	/* (非 Javadoc) 
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see java.lang.Runnable#run() 
	 */ 
	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("run() by "+t);
		System.out.println("eh="+t.getUncaughtExceptionHandler());
		throw new RuntimeException();
	}
	
}

class MyUnCaughtExceptionHandler implements UncaughtExceptionHandler{

	/* (非 Javadoc) 
	 * <p>Title: uncaughtException</p> 
	 * <p>Description: </p> 
	 * @param t
	 * @param e 
	 * @see java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang.Thread, java.lang.Throwable) 
	 */ 
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught "+e);
	}
	
}

class HandlerThreadFactory implements ThreadFactory{

	/* (非 Javadoc) 
	 * <p>Title: newThread</p> 
	 * <p>Description: </p> 
	 * @param r
	 * @return 
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable) 
	 */ 
	@Override
	public Thread newThread(Runnable r) {
		System.out.println(this+" creating new Thread()");
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
		System.out.println("eh="+t.getUncaughtExceptionHandler());
		return t;
	}
	
}
public class CaptureUnCaughtException {

	public static void main(String[] args) {
		//java.lang.Thread.UncaughtExceptionHandler 允许为每个Thread对象附着一个异常处理器
		ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionThread2());
	}
}
