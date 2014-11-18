/**
 * 
 */
package gui.bangBean;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Serializable;
import java.util.TooManyListenersException;

import javax.swing.JPanel;

/**
 * @author Administrator
 *
 */
public class BangBean extends JPanel implements Serializable {

	private int xm,ym;
	private int cSize = 20;		//circle Size
	private String txt = "Bang!!";
	private int fontSize = 48;
	private Color tColor = Color.RED;
	private ActionListener actionListener;
	
	/* (non-Javadoc)
	 * @see java.awt.Container#paintComponents(java.awt.Graphics)
	 */
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		g.setColor(Color.BLACK);
		g.drawOval(xm-cSize/2, ym-cSize/2, cSize, cSize);
	}
	
	public void addActionListener (ActionListener newListener) throws TooManyListenersException{
		if(actionListener!=null)
			throw new TooManyListenersException();
		actionListener = newListener;
	}
	
	public void removeActionListener(){
		actionListener = null;
	}
	
	public BangBean(){
		addMouseListener(new ML());
		addMouseMotionListener(new MML());
	}
	
	public int getcSize() {
		return cSize;
	}

	public void setcSize(int cSize) {
		this.cSize = cSize;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Color gettColor() {
		return tColor;
	}

	public void settColor(Color tColor) {
		this.tColor = tColor;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	
	


	class ML extends MouseAdapter{
		/* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			Graphics g = getGraphics();
			g.setColor(tColor);
			g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
			int width = g.getFontMetrics().stringWidth(txt);
			g.drawString(txt, (getSize().width-width)/2, getSize().height/2);
			g.dispose();
			if(actionListener != null){
				actionListener.actionPerformed(new ActionEvent(BangBean.this, ActionEvent.ACTION_PERFORMED, ""));
			}
			
		}
	}
	
	class MML extends MouseMotionAdapter{
		/* (non-Javadoc)
		 * @see java.awt.event.MouseMotionAdapter#mouseMoved(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseMoved(MouseEvent e) {
			xm = e.getX();
			ym = e.getY();
			repaint();
		}
	}
	
	public Dimension getPreferedSize(){
		return new Dimension(200, 200);
	}
}
