/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class ComboBoxes extends JFrame {

	private String[] description = {
		"Ebullient","Obtuse","Recalcient","Brillent","Somnesent","Timorous","Florid","Putresent"	
	};
	private JTextField t = new JTextField(25);
	private JComboBox c = new JComboBox();
	private JButton b = new JButton("Add Items");
	private int count =0;
	
	public ComboBoxes(){
		for(int i=0;i<4;i++){
			c.addItem(description[count++]);
		}
		t.setEditable(false);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(count<description.length){
					c.addItem(description[count++]);
				}
			}
		});
		c.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t.setText("index "+c.getSelectedIndex()+"  "+((JComboBox)e.getSource()).getSelectedItem());
			}
		});
		setLayout(new FlowLayout());
		add(c);
		add(b);
		add(t);
		
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new ComboBoxes(), 325, 200);
	}
	
	
	
	
	
	
	
	
	
	
}
