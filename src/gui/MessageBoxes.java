/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import utils.SwingConsole;

/**
 * @author Administrator
 * 
 */
public class MessageBoxes extends JFrame {

	private JButton[] b = { new JButton("Alert"), new JButton("Yes/No"),
			new JButton("Color"), new JButton("Input"), new JButton("3 vals"), };

	private JTextField txt = new JTextField(15);
	private ActionListener al = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String id = ((JButton) e.getSource()).getText();
			if ("Alert".equals(id)) {
				JOptionPane.showMessageDialog(null, "There is a bug on you!",
						"hi", JOptionPane.ERROR_MESSAGE);
			} else if ("Yes/No".equals(id)) {
				JOptionPane.showConfirmDialog(null, "or no", "choose yes",
						JOptionPane.YES_NO_OPTION);
			} else if ("Color".equals(id)) {
				Object[] options = { "Red", "Green" };
				int sel = JOptionPane.showOptionDialog(null, "Choose a Color",
						"WarN!", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (sel != JOptionPane.CLOSED_OPTION) {
					txt.setText("Select Color " + options[sel]);
				}
			} else if ("Input".equals(id)) {
				String value = JOptionPane
						.showInputDialog("How many fingers do you have??");
				txt.setText(value);
			} else if ("3 vals".equals(id)) {
				Object[] selections = { "first", "second", "third" };
				Object val = JOptionPane.showInputDialog(null, "Choose one",
						"INput", JOptionPane.INFORMATION_MESSAGE, null,
						selections, selections[1]);
				if(val!=null)
				txt.setText(val.toString());
			}
		}
	};

	public MessageBoxes(){
		setLayout(new FlowLayout());
		for(int i=0;i<b.length;i++){
			b[i].addActionListener(al);
			add(b[i]);
		}
		add(txt);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new MessageBoxes(), 400, 200);
	}
}
