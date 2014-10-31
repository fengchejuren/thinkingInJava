/**
 * 
 */
package object;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


/**
 * @author Tisson
 *
 */
public class UsrInfo {
	private boolean isOnline;
	private String cityId;
	private String qqNum;

	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getQqNum() {
		return qqNum;
	}
	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

	public void addActionListener(ActionListener al){
		
	}

	public void removeActionListener(ActionListener al){
		
	}
	
	public void addKeyListener(KeyListener al){
		
	}
	
	public void removeKeyListener(KeyListener al){
		
	}
	
	public void croak(){
		System.out.println("Please Call me Bound!");
	}
	
	
}
