package containers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetPerformance {

	static List<Test<Set<Integer>>> tests = new ArrayList<Test<Set<Integer>>>();
	static{
		tests.add(new Test<Set<Integer>>("set") {
			
			@Override
			int test(Set<Integer> container, TestParam param) {
				int loops = param.loops;
				int size = param.size;
				for(int i=0;i<loops;i++){
					container.clear();
					for(int j=0;j<size;j++)
						container.add(j);
				}
				return loops*size;
			}
		});
		
		tests.add(new Test<Set<Integer>>("contains") {
			
			@Override
			int test(Set<Integer> container, TestParam param) {
				int loops = param.loops;
				int span = param.size*2;
				for(int i=0;i<loops;i++){
					for(int j=0;j<span;j++)
						container.contains(j);
				}
				return loops*span;
			}
		});
		
		tests.add(new Test<Set<Integer>>("iterator") {
			
			@Override
			int test(Set<Integer> container, TestParam param) {
				int loops = param.loops * 10;
				for(int i=0;i<loops;i++){
					Iterator<Integer> iterator = container.iterator();
					while (iterator.hasNext()) {
						iterator.next();
					}
				}
				return loops*container.size();
			}
		});
	}
	
	public static void main(String[] args) {
		if(args.length>0)
			Tester.defaultParams = TestParam.array(args);
		Tester.fieldWidth = 10;
		Tester.run(new TreeSet<Integer>(), tests);
		Tester.run(new HashSet<Integer>(), tests);
		Tester.run(new LinkedHashSet<Integer>(), tests);
		
	}
	
}
