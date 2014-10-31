/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import utils.SwingConsole;

/**
 * @author Administrator
 *
 */
public class BeanDump extends JFrame{

	private JTextField query = new JTextField(20);
	private JTextArea result = new JTextArea();
	public void print(String s){
		result.append(s+"\n");
	}
	
	public void dump(Class<?> bean){
		result.setText("");
		BeanInfo bi = null;
		try {
			bi = Introspector.getBeanInfo(bean,Object.class);
		} catch (IntrospectionException e) {
			System.out.println("Couldn't Introspector "+bean.getName());
			return;
		}
		for(PropertyDescriptor d:bi.getPropertyDescriptors()){
			Class<?> p = d.getPropertyType();
			if(p==null)
				continue;
			System.out.println("PropertyType :"+p.getName()+"  PropertyName: "+d.getName());
			Method method = d.getReadMethod();
			if(method!=null)
				System.out.println("Read method: "+method);
			Method writeMethod = d.getWriteMethod();
			if(writeMethod!=null)
				System.out.println("Write Method: "+writeMethod);
			System.out.println("=======================");	
			
		}
		System.out.println("Public Methods:");
		for(MethodDescriptor m:bi.getMethodDescriptors()){
			System.out.println(m.getMethod().toString());
		}
		System.out.println("=====================");
		System.out.println("Event Support");
		for(EventSetDescriptor event:bi.getEventSetDescriptors()){
			System.out.println("Listener Type: "+event.getListenerType().getName());
			for(Method m: event.getListenerMethods()){
				System.out.println("Listener Method: "+m.getName());
			}
			for(MethodDescriptor md:event.getListenerMethodDescriptors()){
				System.out.println("Method descriptors: "+md.getMethod());
			}
			Method addListenerMethod = event.getAddListenerMethod();
			System.out.println("Add listener Method: "+addListenerMethod);
			Method removeListenerMethod = event.getRemoveListenerMethod();
			System.out.println("Remove Listener:"+removeListenerMethod);
			System.out.println("===========================");
			
		}
	}
	
	class Dump implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = query.getText();
			Class<?> c = null;
			try {
				c = Class.forName(name);
			} catch (Exception e2) {
				result.setText("Couldn't find Class "+name);
				return;
			}
			dump(c);
		}
		
	}
	
	public BeanDump(){
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.add(new JLabel("Qualified bean name:"));
		p.add(query);
		add(BorderLayout.NORTH,p);
		add(new JScrollPane(result));
		Dump dump = new Dump();
		query.addActionListener(dump);
		query.setText("object.UsrInfo");
		dump.actionPerformed(new ActionEvent(dump, 0, ""));
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new BeanDump(), 500, 500);
	}
	
}
