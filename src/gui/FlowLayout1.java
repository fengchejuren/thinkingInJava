/**
 * 
 */
package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class FlowLayout1 extends JFrame {

	public FlowLayout1(){
		for(int i=0;i<20;i++){
			add(new JButton("button"+(i+1)));
		}
		setLayout(new FlowLayout());
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new FlowLayout1(), 500, 300);
	}
}
