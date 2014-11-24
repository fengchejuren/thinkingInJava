/**  
 * @Title: ThreadVariations.java 
 * @Package concurrency.section2 
 * @Description: TODO 
 * @author Rock King 2014年11月21日 下午9:57:08
 * @version V1.0  
 */ 
package concurrency.section2;

import java.util.concurrent.TimeUnit;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月21日 下午9:57:08 
 * @see ~!^ Keep bugs away and code with U!	 
 */
class InnerThread1{
	private int countdown = 5;
	private Inner inner;
	
	private class Inner extends Thread{
		Inner(String name){
			super(name);
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
				while(true){
					System.out.println(this);
					if(countdown-- == 0)
						return;
					sleep(10);
				}
			} catch (InterruptedException e) {
				System.out.println("Interrupted!");
			}
		}
		/* (非 Javadoc) 
		 * <p>Title: toString</p> 
		 * <p>Description: </p> 
		 * @return 
		 * @see java.lang.Thread#toString() 
		 */ 
		@Override
		public String toString() {
			return getName()+":"+countdown;
		}
	
	}	
	public InnerThread1(String name){
		inner = new Inner(name);
	}
	
}

class InnerThread2{
	private int countDown = 5;
	private Thread t;
	public InnerThread2(String name){
		t = new Thread(name){
			/* (非 Javadoc) 
			 * <p>Title: run</p> 
			 * <p>Description: </p>  
			 * @see java.lang.Thread#run() 
			 */ 
			@Override
			public void run() {
				try {
					while(true){
						System.out.println(this);
						if(countDown--==0) return;
						sleep(10);
					}
				} catch (InterruptedException e) {
					System.out.println("sleep() interupted!");
				}
			}
			/* (非 Javadoc) 
			 * <p>Title: toString</p> 
			 * <p>Description: </p> 
			 * @return 
			 * @see java.lang.Thread#toString() 
			 */ 
			@Override
			public String toString() {
				return getName()+":"+countDown;
			}
		};
		t.start();
	}
	
}

class InnerRunable1{
	private int countDown = 5;
	private Inner inner;
	private class Inner implements Runnable{

		Thread t;
		Inner(String name){
			t = new Thread(this,name);
			t.start();
		}
		/* (非 Javadoc) 
		 * <p>Title: run</p> 
		 * <p>Description: </p>  
		 * @see java.lang.Runnable#run() 
		 */ 
		@Override
		public void run() {
			try {
				while(true){
					System.out.println(this);
					if(countDown--==0)return;
					TimeUnit.MILLISECONDS.sleep(500);
				}
			} catch (InterruptedException e) {
				System.out.println("sleep() interupted!");
			}
		}
		/* (非 Javadoc) 
		 * <p>Title: toString</p> 
		 * <p>Description: </p> 
		 * @return 
		 * @see java.lang.Object#toString() 
		 */ 
		@Override
		public String toString() {
			return t.getName()+":"+countDown;
		}
	}
	public InnerRunable1(String name){
		inner = new Inner(name);
	}
}

class InnerRunnable2{
	private int countDown = 5;
	private Thread t;
	public InnerRunnable2(String name){
		t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true){
						System.out.println(this);
						if(countDown--==0) return;
						TimeUnit.MILLISECONDS.sleep(10);
					}
				} catch (InterruptedException e) {
					System.out.println("sleep() interupted!");
				}
			}
		},name);
		t.start();
	}
}

class ThreadMethod{
	private int countDown = 5;
	private Thread t;
	private String name;
	public ThreadMethod(String name){
		this.name = name;
	}
	public void runTask(){
		if(t==null){
			t=new Thread(name){
				/* (非 Javadoc) 
				 * <p>Title: run</p> 
				 * <p>Description: </p>  
				 * @see java.lang.Thread#run() 
				 */ 
				@Override
				public void run() {
					try {
						while(true){
							System.out.println(this);
							if(countDown--==0) return;
							sleep(10);
						}
					} catch (InterruptedException e) {
						System.out.println("sleep() interupted!");
					}
				}
				/* (非 Javadoc) 
				 * <p>Title: toString</p> 
				 * <p>Description: </p> 
				 * @return 
				 * @see java.lang.Thread#toString() 
				 */ 
				@Override
				public String toString() {
					return getName()+":"+countDown;
				}
			};
			t.start();
		}
	}
}
public class ThreadVariations {

	public static void main(String[] args) {
		new InnerThread1("InnerThread1");
		new InnerThread2("InnerThread2");
		new InnerRunable1("InnerRunnable1");
		new InnerRunnable2("InnerRunnable2");
	}
}
