/**  
 * @Title: EnumSets.java 
 * @Package enumerated 
 * @Description: TODO 
 * @author Rock King 2014年8月23日 上午10:49:02
 * @version V1.0  
 */ 
package enumerated;

import java.util.EnumSet;

import static enumerated.AlarmPoints.*;
/** 用来跟踪AlarmPoints中定义的报警器位置
 * @Description: TODO
 * @author Rock King 2014年8月23日 上午10:49:02 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class EnumSets {

	public static void main(String[] args) {
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
		points.add(OFFICE1);
		System.out.println(points);
		points.addAll(EnumSet.of(BATHROOM, KITCHEN));
		System.out.println(points);
		points = EnumSet.allOf(AlarmPoints.class);
		System.out.println(points);
		points.removeAll(EnumSet.of(OFFICE1,STAIR2));
		System.out.println(points);
		points = EnumSet.complementOf(points);
		System.out.println(points);		
	}
}
