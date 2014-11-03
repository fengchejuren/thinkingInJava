/**
 * 
 */
package gui.bangBean;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class BangBean2 extends JPanel implements Serializable{

	private int xm,ym;
	private int cSize = 20;
	private String txt = "Bang";
	private int fontSize = 48;
	private Color color = Color.RED;
	private ArrayList<ActionListener> actionListeners = new ArrayList<ActionListener>();
	
	public BangBean2(){
		addMouseListener(new ML());
		addMouseMotionListener(new MML());
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.drawOval(xm-cSize/2, ym-cSize/2, cSize, cSize);
	}
	
	public synchronized void addActionListener(ActionListener al){
		actionListeners.add(al);
	}
	
	public synchronized void removeActionListener(ActionListener al){
		actionListeners.remove(al);
	}
	
	public void notifyActionListener(){
		ActionEvent event = new ActionEvent(BangBean2.this, ActionEvent.ACTION_PERFORMED, null);
		ArrayList<ActionListener> list = null;
		//make a shallow copy of the list in case some adds a listener while we are calling actionListeners
		synchronized (this) {
			list = new ArrayList<ActionListener>();
		}
		for(ActionListener al:list)
			al.actionPerformed(event);
	}
	
	public synchronized int getCircleSize(){
		return cSize;
	}
	public synchronized void setCircleSize(int cSize){
		this.cSize = cSize;
	}
	
	public synchronized String getTxt() {
		return txt;
	}

	public synchronized void setTxt(String txt) {
		this.txt = txt;
	}

	public synchronized int getFontSize() {
		return fontSize;
	}

	public synchronized void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public synchronized Color getColor() {
		return color;
	}

	public synchronized void setColor(Color color) {
		this.color = color;
	}



	class ML extends MouseAdapter{
		/* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			Graphics graphics = getGraphics();
			graphics.setColor(color);
			graphics.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
			int width = graphics.getFontMetrics().stringWidth(txt);
			graphics.drawString(txt, (getSize().width-width)/2, getSize().height/2);
			graphics.dispose();
			notifyActionListener();
		}
	}
	
	class MML extends MouseMotionAdapter{
		/* (non-Javadoc)
		 * @see java.awt.event.MouseMotionAdapter#mouseMoved(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseMoved(MouseEvent e) {
			xm = getX();
			ym = getY();
			repaint();
		}
	}
	
	public static void main(String[] args) {
		BangBean2 bangBean2 = new BangBean2();
		bangBean2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ActionEvent "+e);
			}
		});
		bangBean2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("BangBean2 Action "+e);
			}
		});
		bangBean2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("MoreAction ");
			}
		});
		JFrame frame = new JFrame();
		frame.add(bangBean2);
		SwingConsole.run(frame, 500, 300);
		
	}
	
	
}
