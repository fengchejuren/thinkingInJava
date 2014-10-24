/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import utils.Generator;
import utils.RandomGenerator;
import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class TextPane extends JFrame {

	private JButton b = new JButton("Add Text");
	private JTextPane tp = new JTextPane();
	private static Generator sg = new RandomGenerator.String(7);
	
	public TextPane(){
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=1;i<10;i++){
					tp.setText(tp.getText()+sg.next()+"\n");
				}
			}
		});
		add(new JScrollPane(tp));
		add(BorderLayout.SOUTH,b);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new TextPane(), 425, 475);
	}
	
	
	
	
	
	
	
	
}
