/**  
 * @Title: InterrupttedableLongRunningTask.java 
 * @Package gui 
 * @Description: TODO 
 * @author Rock King 2014年10月29日 下午11:32:19
 * @version V1.0  
 */ 
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;

import utils.SwingConsole;

/** 
 * @Description: TODO
 * @author Rock King 2014年10月29日 下午11:32:19 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class InterruptableLongRunningTask extends JFrame {

	private JButton 
		b1 = new JButton("Start Long running Task!"),
		b2 = new JButton("End Long running Task!");
	ExecutorService ecService = Executors.newSingleThreadExecutor();
	public InterruptableLongRunningTask(){
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Task task = new Task();
				ecService.execute(task);
				System.out.println(task+" add to the queue!");
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ecService.shutdownNow();
				
			}
		});
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new InterruptableLongRunningTask(), 200, 150);
	}
}

class Task implements Runnable{

	private static int counter = 0;
	private final int id = counter++;
	@Override
	public void run() {
		System.out.println(this+" started");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted");
			return;
		}
		System.out.println(this+" completed!");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Task "+id;
	}
	
	public long id(){
		return id;
	}
}

