/**  
 * @Title: TaskItem.java 
 * @Package utils 
 * @Description: TODO 
 * @author Rock King 2014年10月30日 上午12:24:39
 * @version V1.0  
 */ 
package utils;

import java.util.concurrent.*;
/** 
 * @Description: TODO
 * @author Rock King 2014年10月30日 上午12:24:39 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class TaskItem<R,C extends Callable<R>> {

	public final Future<R> future;
	public final C task;
	public TaskItem(Future<R> future,C task){
		this.future = future;
		this.task = task;
	}
}
