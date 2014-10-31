/**
 * 
 */
package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.ProgressMonitor;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class Progress extends JFrame {

	private JProgressBar pb = new JProgressBar();
	private ProgressMonitor pm = new ProgressMonitor(this, "Go Progress", "work hard to do it!", 0, 100);
	private JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,60);
	
	public Progress(){
		setLayout(new GridLayout(2,1));
		add(pb);
		pm.setProgress(0);
		pm.setMillisToPopup(1000);
		slider.setValue(0);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setBorder(new TitledBorder("Slide me!"));
		pb.setModel(slider.getModel());
		add(slider);
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				pm.setProgress(slider.getValue());
			}
		});
		
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new Progress(), 300, 200);
	}
	
}
