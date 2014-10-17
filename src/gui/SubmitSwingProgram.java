/**
 * 
 */
package gui;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import sun.tools.asm.Label;

/**
 * @author Administrator
 *
 */
public class SubmitSwingProgram extends JFrame {

	JLabel label;
	public SubmitSwingProgram(){
		super("hello Swing");
		label = new JLabel("a label");
		add(label);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
	}
	
	static SubmitSwingProgram ssProgram;
	
	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ssProgram = new SubmitSwingProgram();
			}
		});
		TimeUnit.SECONDS.sleep(5);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ssProgram.label.setText("imagic, now it is safety!终于成功了。。。");
			}
		});
		
	}
	
}
