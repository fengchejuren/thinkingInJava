/**  
 * @Title: SelfManaged.java 
 * @Package concurrency.section2 
 * @Description: TODO 
 * @author Rock King 2014年11月21日 下午9:50:00
 * @version V1.0  
 */ 
package concurrency.section2;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月21日 下午9:50:00 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class SelfManaged implements Runnable{

	private int countdown = 5;
	private Thread t = new Thread(this);
	
	public SelfManaged(){
		t.start();
	}
	/* (非 Javadoc) 
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#toString() 
	 */ 
	@Override
	public String toString() {
		return Thread.currentThread().getName()+"("+countdown+")";
	}
	/* (非 Javadoc) 
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see java.lang.Runnable#run() 
	 */ 
	@Override
	public void run() {
		while(true){
			System.out.println(this);
			if(--countdown ==0)
				return;
		}
	}

	
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			new SelfManaged();
		}
	}
}
