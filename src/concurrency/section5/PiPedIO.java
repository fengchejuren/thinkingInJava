/**  
 * @Title: PiPedIO.java 
 * @Package concurrency.section5 
 * @Description: TODO 
 * @author Rock King 2014年11月29日 上午11:35:38
 * @version V1.0  
 */ 
package concurrency.section5;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月29日 上午11:35:38 
 * @see ~!^ Keep bugs away and code with U!	 
 */

class Sender implements Runnable{

	private Random random=new Random(47);
	private PipedWriter writer = new PipedWriter();
	public PipedWriter getPipedWriter(){
		return writer;
	}
	@Override
	public void run() {
		try {
			while(true){
				for(char c='a';c<='z';c++){
					System.out.print(c);
					writer.write(c);
					TimeUnit.MILLISECONDS.sleep(2000+random.nextInt(500));
				}
			}
		} catch (IOException e) {
			System.out.println(e+" send writer exception!");
		} catch (InterruptedException e) {
			System.out.println(e+" thread interrupted exception");
		}
			
	}
	
}

class Receiver implements Runnable{

	private PipedReader reader;
	public Receiver(Sender sender) throws IOException{
		reader = new PipedReader(sender.getPipedWriter());
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
				System.out.println("  Read: "+(char)reader.read()+" , ");
			}
		} catch (IOException e) {
			System.out.println(e+" Read.read exception");
		}
	}
	
}
public class PiPedIO {

	public static void main(String[] args)throws Exception {
		Sender sender = new Sender();
		Receiver receiver = new Receiver(sender);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(sender);
		exec.execute(receiver);
		TimeUnit.SECONDS.sleep(35);
		exec.shutdownNow();
	}
}
