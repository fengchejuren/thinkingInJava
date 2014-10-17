/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import utils.Countries;
import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class TextArea extends JFrame {

	private JButton 
		button1 = new JButton("append Data"),
		button2 = new JButton("clear Data");
	private JTextArea t = new JTextArea(10,25);
	private Map<String, String> m = new HashMap<String, String>();
	public TextArea(){
		m.putAll(Countries.captials());
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Map.Entry me:m.entrySet()){
					t.append(me.getKey()+" : "+me.getValue()+"\n");
				}
			}
		});
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t.setText("");
			}
		});
		setLayout(new FlowLayout());
		add(new JScrollPane(t));
		add(button1);
		add(button2);
		
	}
	
	
	public static void main(String[] args) {
		SwingConsole.run(new TextArea(), 500, 300);
	}
	
	
	
	
	
}
