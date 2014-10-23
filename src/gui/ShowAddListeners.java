/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class ShowAddListeners extends JFrame {

	private JTextArea result = new JTextArea(40, 65);
	private JTextField name = new JTextField(25);
	private static Pattern addListener = Pattern.compile("(add\\w+?Listener\\(.*?\\))");
	private static Pattern qualifier = Pattern.compile("\\w+\\.");
	
	class NameL implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String nm = name.getText().trim();
			if(nm.length()==0){
				result.setText("no match");
				return;
			}
			Class<?> kind;
			try {
				kind = Class.forName("javax.swing."+nm);
			} catch (ClassNotFoundException e1) {
				result.setText("no match");
				return;
			}
			Method[] methods = kind.getMethods();
			result.setText("");
			for(Method m:methods){
				Matcher matcher = addListener.matcher(m.toString());
				if(matcher.find()){
					result.append(qualifier.matcher(matcher.group(1)).replaceAll("" )+"\n");
				}
			}
		}
	}
	
	public ShowAddListeners(){
		NameL nameListener = new NameL();
		name.addActionListener(nameListener);
		JPanel top = new JPanel();
		top.add(new JLabel("Swing class name(press Enter):"));
		top.add(name);
		add(BorderLayout.NORTH,top);
		add(new JScrollPane(result));
		name.setText("JTextArea");
		nameListener.actionPerformed(new ActionEvent("", 0, ""));
	}

	public static void main(String[] args) {
		SwingConsole.run(new ShowAddListeners(), 500, 400);
	}
	
}
