/**
 * 
 */
package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**How to read from standard input
 * @author Administrator
 *
 */
public class Echo {

	public static void main(String[] args) throws Exception{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int i=1;
		while((s=stdin.readLine())!=null&&s.length()!=0){
			System.out.println(i++ +" : "+ s);
			
		}
		
	}
	
	
}
