/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class FileChooserTest extends JFrame{

	private JTextField 
		fileName = new JTextField(),
		dir = new JTextField();
	private JButton 
		open = new JButton("Open"),
		save = new JButton("Save");
	public FileChooserTest(){
		JPanel p = new JPanel();
		open.addActionListener(new OpenL());
		p.add(open);
		save.addActionListener(new SaveL());
		p.add(save);
		add(p,BorderLayout.SOUTH);
		dir.setEditable(false);
		fileName.setEditable(false);
		p = new JPanel();
		p.setLayout(new GridLayout(2, 1));
		p.add(fileName);
		p.add(dir);
		add(p,BorderLayout.NORTH);
	}
	
	class OpenL implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser();
			int rval = c.showOpenDialog(FileChooserTest.this);
			if(rval == JFileChooser.APPROVE_OPTION){
				fileName.setText(c.getSelectedFile().getName());
				dir.setText(c.getCurrentDirectory().getName());
			}else if(rval == JFileChooser.CANCEL_OPTION){
				fileName.setText("You pressed Cancel!");
				dir.setText("");
			}
		}
	}
	
	class SaveL implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			int rval = chooser.showSaveDialog(FileChooserTest.this);
			if(rval == JFileChooser.APPROVE_OPTION){
				fileName.setText(chooser.getSelectedFile().getName());
				dir.setText(chooser.getCurrentDirectory().toString());
			}else if(rval == JFileChooser.CANCEL_OPTION){
				fileName.setText("You cancel the save Option!");
				dir.setText("");
			}
		}
		
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new FileChooserTest(), 350, 200);
	}
}
