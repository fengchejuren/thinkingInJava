/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.lang.reflect.Constructor;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class ButtonGroups extends JFrame {

	private String[] ids = {
		"June","Ward","Beaver","Wally","Eddide","Lump"	
	};
	
	static JPanel makeBPanel(
		Class<? extends AbstractButton> kind,String[] ids
			){
		ButtonGroup bg = new ButtonGroup();
		JPanel jp = new JPanel();
		String title = kind.getName();
		title = title.substring(title.lastIndexOf(".")+1);
		jp.setBorder(new TitledBorder(title));
		for(String id : ids){
			AbstractButton ab = new JButton("failed");
			try {
				Constructor ctor = kind.getConstructor(String.class);
				ab = (AbstractButton) ctor.newInstance(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bg.add(ab);
			jp.add(ab);
		}
		return jp;
	}

	public ButtonGroups(){
		setLayout(new FlowLayout());
		add(makeBPanel(JButton.class, ids));
		add(makeBPanel(JToggleButton.class, ids));
		add(makeBPanel(JCheckBox.class, ids));
		add(makeBPanel(JRadioButton.class, ids));
		
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new ButtonGroups(), 500, 350);
		
	}
	
	
	
	
}
