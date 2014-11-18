/**  
 * @Title: LiftOff.java 
 * @Package concurrency 
 * @Description: TODO 
 * @author Rock King 2014年11月18日 下午10:57:15
 * @version V1.0  
 */ 
package concurrency;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月18日 下午10:57:15 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class LiftOff implements Runnable {

	private int countdown = 10;
	private static int counttask = 0;
	private final int id = counttask++;
	public LiftOff(){}
	public LiftOff(int countdown){
		this.countdown = countdown;
	}
	
	public String status(){
		return "#"+id+":("+(countdown>0?countdown:"LiftOff")+")";
	}
	/* (非 Javadoc) 
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see java.lang.Runnable#run() 
	 */ 
	@Override
	public void run() {
		while (countdown-->0) {
			System.out.println(status());
			Thread.yield();
		}
	}

	
	public static void main(String[] args) {
		LiftOff launch = new LiftOff();
		launch.run();
		
	}
	
	
}
