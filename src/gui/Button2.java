/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import static utils.SwingConsole.*;

/**
 * @author Administrator
 *
 */
public class Button2 extends JFrame {

	private JButton
		button1 = new JButton("button1"),
		button2 = new JButton("button2");
	
	private JTextField txtField = new JTextField(10);
	
	class ButtonListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = ((JButton)e.getSource()).getText();
			txtField.setText(name);
		}
		
	}
	
	private ButtonListener bListener = new ButtonListener();
	public Button2(){
		button1.addActionListener(bListener);
		button2.addActionListener(bListener);
		setLayout(new FlowLayout());
		add(button1);
		add(button2);
		add(txtField);
	}
	
	public static void main(String[] args) {
		run(new Button2(), 500, 300);
	}
	
}
