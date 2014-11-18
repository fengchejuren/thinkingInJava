/**  
 * @Title: BasicThread.java 
 * @Package concurrency 
 * @Description: TODO 
 * @author Rock King 2014年11月18日 下午11:08:11
 * @version V1.0  
 */ 
package concurrency;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月18日 下午11:08:11 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class MoreBasicThreads {

	public static void main(String[] args) {
		for(int i=0;i<10;i++)
			new Thread(new LiftOff()).start();
		System.out.println("waiting for LiftOff");
	}
	
}
