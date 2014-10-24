/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class List extends JFrame{

	private String[] flavors = {
		"Chocolate","StrawBerry","Vanlind Fuidge Swing","Mint Chip",
		"Mocha Almond Fudge","Rum Rasin","PradLine Cream","Mud Pile"	
	};
	private DefaultListModel lItems = new DefaultListModel();
	private JList lst = new JList(lItems);
	private JTextArea t = new JTextArea(flavors.length,20);
	private JButton b = new JButton("Add Items");
	private int count =0;
	private ActionListener bl = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(count<flavors.length){
				lItems.add(0, flavors[count++]);
			}else{
				b.setEnabled(false);
			}
		}
	};
	private ListSelectionListener ll = new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(e.getValueIsAdjusting()) return;
			t.setText("");
			for(Object item:lst.getSelectedValues())
				t.append(item+"\n");
		}
	};
	
	public List(){
		t.setEditable(false);
		setLayout(new FlowLayout());
		Border brd = BorderFactory.createMatteBorder(5, 20, 15, 30, Color.BLACK);
		lst.setBorder(brd);
		t.setBorder(brd);
		for(int i=0;i<4;i++)
			lItems.addElement(flavors[count++]);
		add(t);
		add(lst);
		add(b);
		lst.addListSelectionListener(ll);
		b.addActionListener(bl);
		
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new List(), 355, 500);
	}
	
}
