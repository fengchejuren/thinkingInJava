/**  
 * @Title: LongRunningTask.java 
 * @Package gui 
 * @Description: TODO 
 * @author Rock King 2014年10月29日 下午11:17:01
 * @version V1.0  
 */ 
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;

import utils.SwingConsole;

/** 
 * @Description: TODO
 * @author Rock King 2014年10月29日 下午11:17:01 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class LongRunningTask extends JFrame{

	private JButton 
		b1 = new JButton("Start long running Task"),
		b2 = new JButton("End long running Task");
	public LongRunningTask(){
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e1) {
					System.out.println("Task Interruptted");
					return;
				}
				System.out.println("Task completed!");
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread.currentThread().interrupt();
			}
		});
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new LongRunningTask(), 500, 300);
	}
}
