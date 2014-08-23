/**  
 * @Title: EnumMap.java 
 * @Package enumerated 
 * @Description: TODO 
 * @author Rock King 2014年8月23日 上午11:23:45
 * @version V1.0  
 */ 
package enumerated;

import java.util.EnumMap;
import java.util.Map;

interface Command{
	void action();
}
/** 
 * @Description: EnumMap是一种特殊的map,它的key值只能从enum实例里面取值
 * 由于Enum的不可扩展性，因此EnumMap内部可以通过数组来实现。其效率非常的高
 * @author Rock King 2014年8月23日 上午11:23:45 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class EnumMaps {

	public static void main(String[] args) {
		EnumMap<AlarmPoints, Command> eMap = new EnumMap<>(AlarmPoints.class);
		eMap.put(AlarmPoints.BATHROOM, new Command() {
			@Override
			public void action() {
				System.out.println("somebody smoking in the bathroom!");
			}
		});
		eMap.put(AlarmPoints.OFFICE1, new Command() {
			@Override
			public void action() {
				System.out.println("look ,what are they doing in the office");
			}
		});
		for(Map.Entry<AlarmPoints, Command> e:eMap.entrySet()){
			System.out.println(e.getKey()+" : ");
			e.getValue().action();
		}
		System.out.println("----"+eMap.get(AlarmPoints.KITCHEN)+"------");
	}
}
