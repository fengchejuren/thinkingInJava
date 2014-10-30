/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
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
public class Menus extends JFrame {

	private String[] flavors = { "Chocolate", "StrawBerry",
			"Vanlind Fuidge Swing", "Mint Chip", "Mocha Almond Fudge",
			"Rum Rasin", "PradLine Cream", "Mud Pile" };
	private JTextField t = new JTextField("no flavors", 30);
	private JMenuBar mb1 = new JMenuBar();
	private JMenu f = new JMenu("File"), m = new JMenu("Fflavors"),
			s = new JMenu("Safety");
	private JCheckBoxMenuItem[] safety = { new JCheckBoxMenuItem("Guard"),
			new JCheckBoxMenuItem("Hide") };
	private JMenuItem[] file = {new JMenuItem("Open")};
	private JMenuBar mb2 = new JMenuBar();
	private JMenu fooBar = new JMenu("Foo");
	private JMenuItem[] other = {
			// adding a menu shortCut(mnemonic) is very simple,but only
			// JMenuItem can have them in their constructors
			new JMenuItem("Foo", KeyEvent.VK_F),
			new JMenuItem("Bar", KeyEvent.VK_A),
			// no shortcut
			new JMenuItem("Baz") };
	private JButton b = new JButton("Swap Menus");

	class BL implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuBar m = getJMenuBar();
			setJMenuBar(m == mb1 ? mb2 : mb1);
			validate(); // refresh jframe
		}
	}

	class ML implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem target = (JMenuItem) e.getSource();
			String actionCommand = target.getActionCommand();
			if (actionCommand.equals("Open")) {
				String s = t.getText();
				boolean choosen = false;
				for (String flavor : flavors)
					if (s.equals(flavor))
						choosen = true;
				if (!choosen)
					t.setText("Choose a flavor!");
				else
					t.setText("Open " + s + " .MM, mm!");
			}
		}
	}

	class FL implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem) e.getSource();
			t.setText(item.getText());
		}
	}

	// Alternatively,you can create different class for each different
	// MenuItem.Then you don't have to figure out which one it is:
	class FooL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t.setText("FooL selected!!");
		}

	}
	
	class BarL implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			t.setText("BarL selected!!");
		}
		
	}
	
	class BazL implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			t.setText("BazL selected!!");
		}
		
	}

	class CMIL implements ItemListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
		 */
		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBoxMenuItem target = (JCheckBoxMenuItem) e.getSource();
			String actionCommand = target.getActionCommand();
			if(actionCommand.equals("Guard")){
				t.setText("Guard the Iceream. Garding is "+target.getState());
			}else if(actionCommand.equals("Hide")){
				t.setText("Hide the Iceream. Is it hide? "+target.getState());
			}
		}
	}
	
	public Menus(){
		ML ml = new ML();
		CMIL cmil = new CMIL();
		safety[0].setActionCommand("Guard");
		safety[0].setMnemonic(KeyEvent.VK_G);
		safety[0].addItemListener(cmil);
		safety[1].setActionCommand("Hide");
		safety[1].setMnemonic(KeyEvent.VK_H);
		safety[1].addItemListener(cmil);
		other[0].addActionListener(new BarL());
		other[1].addActionListener(new BazL());
		other[2].addActionListener(new FooL());
		FL fl = new FL();
		int n=0;
		for(String flavor:flavors){
			JMenuItem mItem = new JMenuItem(flavor);
			mItem.addActionListener(fl);
			m.add(mItem);
			if((n++ +1)%3==0)
				m.addSeparator();
		}
		for(JCheckBoxMenuItem sfty:safety){
			s.add(sfty);
		}
		s.setMnemonic(KeyEvent.VK_A);
		f.add(s);
		f.setMnemonic(KeyEvent.VK_F);
		for(int i=0;i<file.length;i++){
			file[i].addActionListener(ml);
			f.add(file[i]);
		}
		mb1.add(f);
		mb1.add(m);
		setJMenuBar(mb1);
		t.setEditable(false);
		add(t,BorderLayout.CENTER);
		b.addActionListener(new BL());
		b.setMnemonic(KeyEvent.VK_S);
		add(b,BorderLayout.NORTH);
		for(JMenuItem jt:other){
			fooBar.add(jt);
		}
		fooBar.setMnemonic(KeyEvent.VK_B);
		mb2.add(fooBar);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new Menus(), 500, 300);
	}
}
