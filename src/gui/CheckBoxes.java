/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class CheckBoxes extends JFrame {

	private JTextArea t = new JTextArea(25,65);
	private JCheckBox 
		cb1 = new JCheckBox("CheckBox1"),
		cb2 = new JCheckBox("CheckBox2"),
		cb3 = new JCheckBox("CheckBox3");
	public CheckBoxes(){
		cb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				trace("1",cb1);
			}
		});
		cb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				trace("2", cb2);
			}
		});
		cb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				trace("3", cb3);
			}
		});
		setLayout(new FlowLayout());
		add(new JScrollPane(t));
		add(cb1);
		add(cb2);
		add(cb3);
	}

	public static void main(String[] args) {
		SwingConsole.run(new CheckBoxes(), 200, 300);
	}
	
	private void trace(String b,JCheckBox cb){
		if(cb.isSelected())
			t.append("Box "+b+" Set:\n");
		else
			t.append("Box "+b+" Cleared:\n");
	}
}
