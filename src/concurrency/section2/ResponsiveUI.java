/**  
 * @Title: ResponsiveUI.java 
 * @Package concurrency.section2 
 * @Description: TODO 
 * @author Rock King 2014年11月26日 上午12:19:49
 * @version V1.0  
 */ 
package concurrency.section2;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月26日 上午12:19:49 
 * @see ~!^ Keep bugs away and code with U!	 
 */
class UnResponsiveUI {
	private volatile double d = 1;
	public UnResponsiveUI()throws Exception{
		while(d>0)
			d = d+(Math.PI+Math.E)/d;
		System.in.read();	//never gets here
	}
}
public class ResponsiveUI extends Thread {

	private static volatile double d = 1;
	public ResponsiveUI(){
		setDaemon(true);
		start();
	}
	/* (非 Javadoc) 
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see java.lang.Thread#run() 
	 */ 
	@Override
	public void run() {
		while(true){
			d = d+(Math.E+Math.PI)/d;
		}
	}
	
	public static void main(String[] args) throws Exception{
		//new UnResponsiveUI();
		new ResponsiveUI();
		System.in.read();
		System.out.println(d);
		
	}
	
}
