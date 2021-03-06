/**
 * 
 */
package utils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author Administrator
 *
 */
public class SwingConsole {

	public static void run(final JFrame frame,final int width,final int height){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				frame.setTitle(frame.getClass().getSimpleName());
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setSize(width,height);
				frame.setVisible(true);
			}
		});
	}
	
}
