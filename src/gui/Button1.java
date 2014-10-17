/**
 * 
 */
package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import static utils.SwingConsole.*;

/**
 * @author Administrator
 *
 */
public class Button1 extends JFrame {

	private JButton
		button1 = new JButton("button1"),
		button2 = new JButton("button2");
	
	public Button1(){
		setLayout(new FlowLayout());
		add(button1);
		add(button2);
	}
	
	public static void main(String[] args) {
		run(new Button1(), 500, 300);
	}
	
}
