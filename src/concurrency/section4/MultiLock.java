package concurrency.section4;


public class MultiLock {

	public synchronized void f1(int count){
		if(count-->0){
			System.out.println("f1() calling f2() with count "+count);
			f2(count);
		}
	}

	public synchronized void f2(int count) {
		if(count-->0){
			System.out.println("f2() calling f1() with count "+count);
			f1(count);
		}	
	}
	
	/**f1()和f2()互相调用，调用f1()的时候获取MultiLock对象锁，同一个任务在调用f2()的时候再次获取这个对象锁
	 * @param args
	 */
	public static void main(String[] args) {
		final MultiLock multiLock = new MultiLock();
		new Thread(){
			public void run() { multiLock.f1(10);}
		}.start();
		
	}
}
