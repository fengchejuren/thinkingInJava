/**  
 * @Title: TaskManager.java 
 * @Package utils 
 * @Description: TODO 
 * @author Rock King 2014年10月30日 上午12:32:30
 * @version V1.0  
 */ 
package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.tools.javac.jvm.Items;

/** 
 * @Description: TODO
 * @author Rock King 2014年10月30日 上午12:32:30 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class TaskManager<R,C extends Callable<R>> extends ArrayList<TaskItem<R, C>>{

	private ExecutorService ecService = Executors.newSingleThreadExecutor();
	public void add(C task){
		add(new TaskItem<R, C>(ecService.submit(task), task));
	}
	public List<R> getResults(){
		Iterator<TaskItem<R, C>> items = iterator();
		List<R> results = new ArrayList<R>();
		while(items.hasNext()){
			TaskItem<R, C> item = items.next();
			if(item.future.isDone()){
				try {
					results.add(item.future.get());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				items.remove();
			}
		}
		return results;
	}
	
	public List<String> purge(){
		Iterator<TaskItem<R, C>> iterator = iterator();
		List<String> results = new ArrayList<String>();
		while(iterator.hasNext()){
			TaskItem<R, C> item = iterator.next();
			if(!item.future.isDone()){
				results.add("Canceling "+item.task);
				item.future.cancel(true);
				iterator.remove();
			}
		}
		return results;
	}
	
}
