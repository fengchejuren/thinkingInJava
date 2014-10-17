/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sun.tools.asm.Label;

/**
 * @author Administrator
 *
 */
public class TrackEvent extends JFrame{
	
	private Map<String, JTextField> h = new HashMap<String, JTextField>();
	private String[] event = {"focusGained","focusLost","keyPressed","keyReleased","keyTyped",
			"monseClicked","mousePressed","mouseMoved","mouseReleased","mouseEntered",
			"mouseExited","mouseDragged"};
	private MyButton 
		button1 = new MyButton(Color.blue, "test1"),
		button2 = new MyButton(Color.blue, "test1");
	class MyButton extends JButton{
		void report(String field,String msg){
			h.get(field).setText(msg);
		}
		FocusListener fl = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				report("focusLost", e.paramString());
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				report("focusGained", e.paramString());
			}
		};
		KeyListener kl = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				report("keyTyped", e.paramString());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				report("keyReleased", e.paramString());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				report("keyPressed", e.paramString());	
			}
		};
		MouseListener ml = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				report("mouseReleased", e.paramString());
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				report("mousePressed", e.paramString());
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				report("mouseExited", e.paramString());
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				report("mouseEntered", e.paramString());
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				report("mouseClicked", e.paramString());
			}
		};
		MouseMotionListener mml = new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				report("mouseMoved", e.paramString());	
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				report("mouseDragged", e.paramString());	
			}
		};	
	
		public MyButton(Color color,String label){
			super(label);
			setBackground(color);
			addFocusListener(fl);
			addKeyListener(kl);
			addMouseListener(ml);
			addMouseMotionListener(mml);
		}
	}

	public TrackEvent(){
		setLayout(new GridLayout(event.length+1, 2));
		for(String evn:event){
			JTextField textField = new JTextField();
			textField.setEditable(false);
			add(new JLabel(evn,JLabel.RIGHT));
			add(textField);
			h.put(evn, textField);
		}
		add(button1);
		add(button2);
	}
	
}
