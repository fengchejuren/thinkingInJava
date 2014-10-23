/**
 * 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class Faces extends JFrame {

	private static Icon[] faces;
	private JButton jb,jb2 = new JButton("Disabled");
	private boolean mad = false;
	
	public Faces(){
		faces = new Icon[] {
				new ImageIcon(getClass().getResource("img1.jpg")),
				new ImageIcon(getClass().getResource("img2.jpg")),
				new ImageIcon(getClass().getResource("img3.jpg")),
				new ImageIcon(getClass().getResource("img4.jpg"))
		};
		jb = new JButton("JButton",faces[3]);
		setLayout(new FlowLayout());
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mad){
					jb.setIcon(faces[3]);
					mad = false;
				}else{
					jb.setIcon(faces[0]);
					mad = true;
				}
				jb.setVerticalAlignment(JButton.TOP);
				jb.setHorizontalAlignment(JButton.LEFT);
			}
		});
		jb.setRolloverEnabled(true);
		jb.setRolloverIcon(faces[1]);
		jb.setPressedIcon(faces[2]);
		jb.setDisabledIcon(faces[3]);
		jb.setToolTipText("YOw!");
		add(jb);
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(jb.isEnabled()){
					jb.setEnabled(false);
					jb2.setText("Enable");
				}else{
					jb.setEnabled(true);
					jb2.setText("Disable");
				}
			}
		});
		add(jb2);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new Faces(), 150, 225);
	}
	
}
