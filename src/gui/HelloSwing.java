/**
 * 
 */
package gui;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * @author Administrator
 *
 */
public class HelloSwing {

	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("hello Swing");
		final JLabel label = new JLabel("a good label");
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setVisible(true);
		label.setBackground(new Color(99,99,99));
		TimeUnit.SECONDS.sleep(5);
		//label.setText("it looks imagic!");  不安全，线程阻塞
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				label.setText("it looks imagic!");
			}
		});
		
	}
	
}
