/**  
 * @Title: SimpleThread.java 
 * @Package concurrency.section2 
 * @Description: TODO 
 * @author Rock King 2014年11月21日 下午9:42:16
 * @version V1.0  
 */ 
package concurrency.section2;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月21日 下午9:42:16 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class SimpleThread extends Thread {

	private int countdown = 5;
	private static int count=0;
	public SimpleThread(){
		super(Integer.toString(++count));
		start();
	}
	
	@Override
	public void run() {
		while(true){
			System.out.println(this);
			if(--countdown == 0)
				return;
		}
	}
	
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			new SimpleThread();
		}
	}
}
