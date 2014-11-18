/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import utils.SwingConsole;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author Administrator
 *
 */
class SineDraw extends JPanel{
	private static final int SCALEFACTOR = 200;
	private int cycles;
	private int points;
	private double[] sines;
	private int[] pts;
	public SineDraw(){setCycles(5);}
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		int maxWidth = getWidth();
		double hstep = (double)maxWidth / (double)points;
		int maxHeight = getHeight();
		pts = new int[points];
		for(int i=0;i<points;i++){
			pts[i] = (int) (sines[i]*maxHeight /2 * .95 + maxHeight/2);
		}
		g.setColor(Color.RED);
		for(int i=1;i<points;i++){
			int x1 = (int) ((i-1)*hstep);
			int x2 = (int) (i*hstep);
			int y1 = pts[i-1];
			int y2 = pts[i];
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
	public void setCycles(int newCycles){
		cycles = newCycles ;
		points = SCALEFACTOR*newCycles*2;
		sines = new double[points];
		for(int i=0;i<sines.length;i++){
			double radians = (Math.PI/SCALEFACTOR)*i;
			sines[i] = Math.sin(radians);
		}
		repaint();
	}
}

public class SineWave extends JFrame {

	private SineDraw sines = new SineDraw();
	private JSlider adjustCycles = new JSlider(1,30,5);
	public SineWave(){
		add(sines);
		adjustCycles.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				sines.setCycles(((JSlider)arg0.getSource()).getValue());
			}
		});
		add(BorderLayout.SOUTH,adjustCycles);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new SineWave(), 300, 500);
	}
}
