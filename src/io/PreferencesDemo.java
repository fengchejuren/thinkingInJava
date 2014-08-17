/**  
 * @Title: PreferencesDemo.java 
 * @Package io 
 * @Description: TODO 
 * @author Rock King 2014年8月16日 上午8:58:30
 * @version V1.0  
 */ 
package io;

import java.util.prefs.Preferences;

/** 
 * @Description: TODO
 * @author Rock King 2014年8月16日 上午8:58:30 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class PreferencesDemo {

	public static void main(String[] args) throws Exception {
		Preferences preferences = Preferences.userNodeForPackage(PreferencesDemo.class);
		preferences.put("location", "0z");
		preferences.put("Footware", "Ruby Slippers");
		preferences.putInt("Companions", 4);
		preferences.putBoolean("Are the wishes?", true);
		int usageCount = preferences.getInt("UsageCount",0);
		usageCount++;
		preferences.putInt("UsageCount", usageCount);
		for(String key:preferences.keys())
			System.out.println(key+": "+preferences.get(key, null));
		System.out.println("How many companions does the Deroby have? "+preferences.getInt("Companions", 0));
		
		
		
		
	}
	
	
}
