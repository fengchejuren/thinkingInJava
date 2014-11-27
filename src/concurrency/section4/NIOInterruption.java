package concurrency.section4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class NIOBlock implements Runnable{

	private final SocketChannel sChannel;
	
	public NIOBlock(SocketChannel sChannel){
		this.sChannel = sChannel;
	}
	public void run() {
			System.out.println("waiting for read() in "+this);
			try {
				sChannel.read(ByteBuffer.allocate(0));
			} catch (ClosedByInterruptException e) {
				System.out.println("ClosedByInterruptException");
			} catch (AsynchronousCloseException e){
				System.out.println("AsynchronousCloseException");
			} catch (IOException e) {
				throw new RuntimeException();
			}
			System.err.println("exiting BIOBlock.run()"+this);
	}
	
}
public class NIOInterruption {

	public static void main(String[] args) throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool();
		ServerSocket server = new ServerSocket(8080);
		InetSocketAddress isAddress = new InetSocketAddress("localhost",8080);
		SocketChannel sc1 = SocketChannel.open(isAddress);
		SocketChannel sc2 = SocketChannel.open(isAddress);
		Future<?> future = exec.submit(new NIOBlock(sc1));
		exec.execute(new NIOBlock(sc2));
		exec.shutdown();
		TimeUnit.SECONDS.sleep(3);
		future.cancel(true);
		TimeUnit.SECONDS.sleep(3);
		sc2.close();
		
		
	}
}
