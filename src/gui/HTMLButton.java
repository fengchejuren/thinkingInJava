/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class HTMLButton extends JFrame {

	private JButton button = new JButton("<html><b><font size=+2> <center>hello!<br><i>Press now!");
	
	public HTMLButton(){
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add(new JLabel("<html><i><font size=+4>Kapow!"));
				validate();
			}
		});
		setLayout(new FlowLayout());
		add(button);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new HTMLButton(), 500, 300);
	}
}
