/**  
 * @Title: InterruptableLongRunningCallable.java 
 * @Package gui 
 * @Description: TODO 
 * @author Rock King 2014年10月30日 上午12:56:09
 * @version V1.0  
 */ 
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JFrame;

import utils.SwingConsole;
import utils.TaskItem;
import utils.TaskManager;

/** 
 * @Description: TODO
 * @author Rock King 2014年10月30日 上午12:56:09 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class InterruptableLongRunningCallable extends JFrame {

	private JButton 
		b1 = new JButton("Start Long Running Task"),
		b2 = new JButton("End Long Running Task"),
		b3 = new JButton("Get Results");
	private TaskManager<String, CallableTask> manager = new TaskManager<>();
	
	public InterruptableLongRunningCallable(){
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CallableTask task = new CallableTask();
				manager.add(task);
				System.out.println(task+" added to the queue");
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(String result:manager.purge()){
					System.out.println(result);
				}
			}
		});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(TaskItem<String, CallableTask> item:manager)
					item.task.id();
				for(String result:manager.getResults())
					System.out.println(result);
			}
		});
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(b3);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new InterruptableLongRunningCallable(), 300, 250);
	}
}

class CallableTask extends Task implements Callable<String>{

	/* (非 Javadoc) 
	 * <p>Title: call</p> 
	 * <p>Description: </p> 
	 * @return
	 * @throws Exception 
	 * @see java.util.concurrent.Callable#call() 
	 */ 
	@Override
	public String call() throws Exception {
		run();
		return "Return value of "+this;
	}
	
}