/**
 * 
 */
package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class TabbedPane1 extends JFrame{

	private String[] flavors = {
			"Chocolate","StrawBerry","Vanlind Fuidge Swing","Mint Chip",
			"Mocha Almond Fudge","Rum Rasin","PradLine Cream","Mud Pile"	
		};
	private JTabbedPane tabs = new JTabbedPane();
	private JTextField text = new JTextField(25);
	public TabbedPane1(){
		int i=0;
		for(String string:flavors)
			tabs.addTab(flavors[i], new JButton("Tabbed Pane "+i++));
		tabs.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				text.setText("Tabs selected "+tabs.getSelectedIndex());
			}
		});
		add(BorderLayout.SOUTH,text);
		add(tabs);
	}
	public static void main(String[] args) {
		SwingConsole.run(new TabbedPane1(), 400, 250);
	}
	
	
	

}
