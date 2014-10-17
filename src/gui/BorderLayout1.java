/**
 * 
 */
package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class BorderLayout1 extends JFrame{

	public BorderLayout1(){
		add(BorderLayout.NORTH, new JButton("NORTH"));
		add(BorderLayout.SOUTH, new JButton("SOUTH"));
		add(BorderLayout.WEST, new JButton("WEST"));
		add(BorderLayout.EAST, new JButton("EAST"));
		add(BorderLayout.CENTER, new JButton("CENTER"));
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new BorderLayout1(), 500, 300);
	}
}
