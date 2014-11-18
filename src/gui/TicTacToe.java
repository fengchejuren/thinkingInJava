/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class TicTacToe extends JFrame{

	private JTextField rows = new JTextField("3");
	private JTextField columns = new JTextField("3");
	private enum State {BLANK,XX,OO};
	
	static class ToeDialog extends JDialog{
		private State turn = State.XX;
		/**
		 * 
		 */
		public ToeDialog(int cellWidth,int cellHeight) {
			setTitle("the game itself");
			setLayout(new GridLayout(cellWidth, cellHeight));
			for(int i=0;i<cellWidth*cellHeight;i++){
				add(new ToeButton());
			}
			setSize(cellWidth*50,cellHeight*50);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}

		class ToeButton extends JPanel{
			private State state = State.BLANK;
			public ToeButton(){
				addMouseListener(new ML());
			}
			/* (non-Javadoc)
			 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
			 */
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				int 
					x1 = 0, y1 = 0,
					x2 = getSize().width-1,
					y2 = getSize().height-1;
				g.drawRect(x1, y1, x2, y2);
				x1 = x2/4;
				y1 = y2/4;
				int wide = x2/2,
					high = y2/2;
				if(state == State.XX){
					g.drawLine(x1, y1, x1+wide, y1+high);
					g.drawLine(x1, y1+high, x1+wide, y1);
				}
				if(state == State.OO){	
					g.drawOval(x1,y1, x1+wide/2	, y1+high/2);
				}
			}
			
			class ML extends MouseAdapter{
				/* (non-Javadoc)
				 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
				 */
				@Override
				public void mousePressed(MouseEvent e) {
					if(state==State.BLANK){
						state = turn;
						turn = (turn==State.OO?State.XX:State.OO);
					}else{
						state = (state ==State.XX?State.OO:State.XX);
					}
					repaint();
				}
			}
		}
		
	}
	
	class BL implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog dialog = new ToeDialog(new Integer(rows.getText()), 
					new Integer(columns.getText()));
			dialog.setVisible(true);
		}
		
	}
	
	public TicTacToe(){
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2,2));
		p.add(new JLabel("Rows",JLabel.CENTER));
		p.add(rows);
		p.add(new JLabel("Columns",JLabel.CENTER));
		p.add(columns);
		add(p,BorderLayout.NORTH);
		JButton b = new JButton("GO");
		b.addActionListener(new BL());
		add(b,BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new TicTacToe(), 200, 200);
	}
}
