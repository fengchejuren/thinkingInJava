/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class Popup extends JFrame {

	private JPopupMenu popUp = new JPopupMenu();
	private JTextField txt = new JTextField(10);
	
	public Popup(){
		setLayout(new FlowLayout());
		add(txt);
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txt.setText(((JMenuItem)e.getSource()).getText());
			}
		};
		JMenuItem m = new JMenuItem("Heither");
		m.addActionListener(al);
		popUp.add(m);
		m = new JMenuItem("Yon");
		m.addActionListener(al);
		popUp.add(m);
		m = new JMenuItem("Afer");
		m.addActionListener(al);
		popUp.add(m);
		popUp.addSeparator();
		m = new JMenuItem("Stay Here");
		m.addActionListener(al);
		popUp.add(m);
		PopupListener ppListener = new PopupListener();
		addMouseListener(ppListener);
		txt.addMouseListener(ppListener);
	}
	
	class PopupListener extends MouseAdapter{
		/* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			maybeShowPopup(e);
		}
		/* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseReleased(MouseEvent e) {
			maybeShowPopup(e);
		}
		
		private void maybeShowPopup(MouseEvent e){
			if(e.isPopupTrigger()){
				popUp.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new Popup(), 300, 500);
	}
	
}
