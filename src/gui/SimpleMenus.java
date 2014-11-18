/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class SimpleMenus extends JFrame {

	private JTextField t = new JTextField(15);
	private ActionListener al = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			t.setText(((JMenuItem)e.getSource()).getText());
		}
	};
	private JMenu[] menus = {
			new JMenu("Winken"),new JMenu("Blinken"),
			new JMenu("Nod")
	};
	private JMenuItem[] items = {
			new JMenuItem("Foo"),new JMenuItem("Fi"),
			new JMenuItem("Fee"),new JMenuItem("Zip"),
			new JMenuItem("Zap"),new JMenuItem("Zot"),
			new JMenuItem("Olly"),new JMenuItem("Oxen"),
			new JMenuItem("Free")
	};
	
	public SimpleMenus(){
		for(int i=0;i<items.length;i++){
			items[i].addActionListener(al);
			menus[i%3].add(items[i]);
		}
		JMenuBar bar = new JMenuBar();
		for(JMenu menu:menus){
			bar.add(menu);
		}
		setJMenuBar(bar);
		setLayout(new FlowLayout());
		add(t);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new SimpleMenus(), 500, 300);
	}
	
	
	
	
	
	
	
	
	
	
	
}
