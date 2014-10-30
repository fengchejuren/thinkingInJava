/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
class MyDialog extends JDialog{
	public MyDialog(JFrame parent){
		super(parent,"MyDialog",true);
		setLayout(new FlowLayout());
		add(new JLabel("This is MyDialog!"));
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		add(ok);
		setSize(150,125);
	}
	
}

public class Dialogs extends JFrame {

	private JButton b1 = new JButton("Dialog Box");
	private MyDialog mDialog = new MyDialog(null);
	public Dialogs(){
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mDialog.setVisible(true);
			}
		});
		add(b1);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new Dialogs(), 125, 75);
	}
	
	
}
