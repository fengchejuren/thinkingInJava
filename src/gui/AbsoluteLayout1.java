/**
 * 
 */
package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class AbsoluteLayout1 extends JFrame{

	public AbsoluteLayout1(){
		setLayout(null);
		JButton button1 = new JButton("Button1");
		button1.setBounds(70, 130, 80,30);
		add(button1);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new AbsoluteLayout1(), 300, 300);
	}
}
