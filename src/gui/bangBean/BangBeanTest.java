/**
 * 
 */
package gui.bangBean;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TooManyListenersException;

import javax.swing.JFrame;
import javax.swing.JTextField;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class BangBeanTest extends JFrame {

	private JTextField textField = new JTextField(20);
	
	class BBL implements ActionListener{

		private int count = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			textField.setText("BangBean action "+count++);
		}
		
	}
	
	public BangBeanTest(){
		BangBean bb = new BangBean();
		try {
			bb.addActionListener(new BBL());
		} catch (TooManyListenersException e) {
			System.out.println("toomany Listeneres");
		}
		add(bb);
		add(BorderLayout.SOUTH,textField);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new BangBeanTest(), 400, 500);
	}
}
