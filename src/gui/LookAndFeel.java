/**
 * 
 */
package gui;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class LookAndFeel extends JFrame {

	private String[] choices = "mary molly millzb lozy herry goodsyb flld".split(" ");
	private Component[] components = {
			new JButton("JButton"),
			new JTextField("JTextField"),
			new JLabel("JLabel"),
			new JCheckBox("JCheckBox"),
			new JComboBox(choices),
			new JRadioButton("JRadioButton"),
			new JList(choices)
	};
	
	public LookAndFeel(){
		super("Look And Feel");
		setLayout(new FlowLayout());
		for(Component component:components)
			add(component);
	}
	
	private static void usageError(){
		System.out.println("Usage: LookAndFeel [cross|system|modif]");
		System.exit(1);
	}
	
	public static void main(String[] args) {
		if(args.length==0)
			usageError();
		if(args[0].equals("cross")){
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else if(args[0].equals("system")){
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else if(args[0].equals("motif")){
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else {
			usageError();
		}
		
		SwingConsole.run(new LookAndFeel(), 500, 500);
		
	}
	
	
	
}
