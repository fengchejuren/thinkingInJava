/**
 * 
 */
package gui;

import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 * @author Administrator
 *
 */
public class Menus extends JFrame {

	private String[] flavors = {
			"Chocolate","StrawBerry","Vanlind Fuidge Swing","Mint Chip",
			"Mocha Almond Fudge","Rum Rasin","PradLine Cream","Mud Pile"	
		};
	private JTextField t = new JTextField("no flavors",30);
	private JMenuBar mb1 = new JMenuBar();
	private JMenu 
		f = new JMenu("File"),
		m = new JMenu("Fflavors"),
		s = new JMenu("Safety");
	private JCheckBoxMenuItem[] safety = {
			new JCheckBoxMenuItem("Guard"),new JCheckBoxMenuItem("Hide")
	};	
	private JMenuBar mb2 = new JMenuBar();
	private JMenu fooBar = new JMenu("Foo");
	private JMenuItem[] other = {
		//adding a menu shortCut(mnemonic) is very simple,but only JMenuItem can have them in their constructors	
			new JMenuItem("Foo", KeyEvent.VK_F),
			new JMenuItem("Bar", KeyEvent.VK_A),
		//no shortcut
			new JMenuItem("Baz")
			
	};
	
}
