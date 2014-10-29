/**  
 * openning file on a local machine
 * {Requires:javax.jnlp.FileOpenService;
 * you must have javaws.jar in your classpath} 
 * to create jnlpFileChooser.jar file,do this:
 * cd:
 * cd:
 * jar cvf gui/jnlp/jnlpFileChooser.jar gui/jnlp/*.class
 * @Package gui.jnlp 
 * @Description: TODO 
 * @author Rock King 2014年10月28日 上午12:44:58
 * @version V1.0  
 */
package gui.jnlp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.jnlp.FileContents;
import javax.jnlp.FileOpenService;
import javax.jnlp.FileSaveService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import utils.SwingConsole;

/**
 * @Description: TODO
 * @author Rock King 2014年10月28日 上午12:44:58
 * @see ~!^ Keep bugs away and code with U!
 */

public class JnlpFileChooser extends JFrame {

	private JTextField fileName = new JTextField();
	private JButton open = new JButton("Open"), save = new JButton("save");
	private JEditorPane ep = new JEditorPane();
	private JScrollPane jsp = new JScrollPane();
	private FileContents fileContents;

	public JnlpFileChooser() {
		JPanel p = new JPanel();
		open.addActionListener(new OpenL());
		p.add(open);
		save.addActionListener(new SaveL());
		p.add(save);
		jsp.getViewport().add(ep);
		add(jsp, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		fileName.setEditable(false);
		p = new JPanel();
		p.setLayout(new GridLayout(2, 1));
		p.add(fileName);
		add(p, BorderLayout.NORTH);
		ep.setContentType("text");
		save.setEnabled(false);

	}
	
	public static void main(String[] args) {
		JnlpFileChooser fc = new JnlpFileChooser();
		fc.setSize(400,300);
		fc.setVisible(true);
	}

	class OpenL implements ActionListener {

		/*
		 * (非 Javadoc) <p>Title: actionPerformed</p> <p>Description: </p>
		 * 
		 * @param e
		 * 4
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			FileOpenService fs = null;
			try {
				fs = (FileOpenService) ServiceManager
						.lookup("javax.jnlp.FileOpenService");
			} catch (UnavailableServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (fs != null) {
				try {
					fileContents = fs.openFileDialog(".", new String[] { "txt",
							"" });
					if (fileContents == null)
						return;
					fileName.setText(fileContents.getName());
					ep.read(fileContents.getInputStream(), null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				save.setEnabled(true);
			}
		}

	}

	class SaveL implements ActionListener {

		/*
		 * (非 Javadoc) <p>Title: actionPerformed</p> <p>Description: </p>
		 * 
		 * @param e
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			FileSaveService fs = null;
			try {
				fs = (FileSaveService) ServiceManager
						.lookup("javax.jnlp.FileSaveService");
			} catch (UnavailableServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (fs != null) {
				try {
					fileContents = fs.saveFileDialog(".", new String[] { "txt" },
							new ByteArrayInputStream(ep.getText().getBytes()),fileContents.getName());
					if(fileContents==null)
						return;
					fileName.setText(fileContents.getName());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}
}
