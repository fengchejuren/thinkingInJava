package containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

/**测试Map的不同实现，对性能的影响
 * @author Administrator
 *
 */
public class MapPerformance {

	static List<Test<Map<Integer,Integer>>> tests = new ArrayList<Test<Map<Integer,Integer>>>();
	
	static{
		tests.add(new Test<Map<Integer,Integer>>("put") {
			
			@Override
			int test(Map<Integer, Integer> container, TestParam param) {
				int loops = param.loops;
				int size = param.size;
				for(int i=0;i<loops;i++){
					container.clear();
					for(int j=0;j<size;j++)
						container.put(i, j);
				}
				return loops*size;
			}
		});
		
		tests.add(new Test<Map<Integer,Integer>>("get") {
			
			@Override
			int test(Map<Integer, Integer> container, TestParam param) {
				int loops = param.loops;
				int span = param.size*2;
				for(int i=0;i<loops;i++){
					container.clear();
					for(int j=0;j<span;j++)
						container.get(j);
				}
				return loops*span;
			}
		});
		
		tests.add(new Test<Map<Integer,Integer>>("iterate") {
			
			@Override
			int test(Map<Integer, Integer> container, TestParam param) {
				int loops = param.loops*10;
				for(int i=0;i<loops;i++){
					Iterator iterator = container.entrySet().iterator();
					while(iterator.hasNext())
						iterator.next();
				}
				return loops*container.size();
			}
		});
		
		
	}
	
	
	public static void main(String[] args) {
		if(args.length>0)
			Tester.defaultParams = TestParam.array(args);
		Tester.run(new TreeMap<Integer, Integer>(), tests);
		Tester.run(new HashMap<Integer, Integer>(), tests);
		Tester.run(new LinkedHashMap<Integer, Integer>(), tests);
		Tester.run(new IdentityHashMap<Integer, Integer>(), tests);
		Tester.run(new WeakHashMap<Integer, Integer>(), tests);
		Tester.run(new Hashtable<Integer, Integer>(), tests);
		
	}
	
	
	
}
