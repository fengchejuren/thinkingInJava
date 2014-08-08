package containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

import arrays.CountingGenerator;

import utils.CountingIntegerList;
import utils.Generated;

/**
 * Demontrates performance different in lists
 * 
 * @author Administrator
 * 
 */
public class ListPerformance {

	static Random random = new Random(47);
	static int reps = 1000;
	static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();
	static List<Test<LinkedList<Integer>>> qTests = new ArrayList<Test<LinkedList<Integer>>>();
	static{
		tests.add(new Test<List<Integer>>("add") {
			
			@Override
			int test(List<Integer> container, TestParam param) {
				int loops = param.loops;
				int listsize = param.size;
				for (int i = 0; i < loops; i++) {
					container.clear();
					for(int j=0;j<listsize;j++)
						container.add(j);
				}
				return loops*listsize;
			}
		});
		
		tests.add(new Test<List<Integer>>("get") {
			
			@Override
			int test(List<Integer> container, TestParam param) {
				int loops = param.loops*reps;
				int listsize = container.size();
				for(int i=0;i<listsize;i++)
					container.get(random.nextInt(listsize));
				return loops;
			}
		});
		
		tests.add(new Test<List<Integer>>("set") {
			
			@Override
			int test(List<Integer> container, TestParam param) {
				int loops = param.loops*reps;
				int listsize = container.size();
				for(int i=0;i<listsize;i++)
					container.set(random.nextInt(listsize), 47);
				return loops;
			}
		});
		
		tests.add(new Test<List<Integer>>("iteradd") {
			
			@Override
			int test(List<Integer> container, TestParam param) {
				final int LOOPS = 1000000;
				int half = container.size()/2;
				ListIterator<Integer> iterator = container.listIterator(half);
				for(int i=0;i<LOOPS;i++)
					iterator.add(47);
				return LOOPS;
			}
		});
		
		tests.add(new Test<List<Integer>>("insert") {
			
			@Override
			int test(List<Integer> container, TestParam param) {
				int loops = param.loops;
				for(int i=0;i<loops;i++)
					container.add(5,47);	//Minimize random-access costs
				return loops;
			}
		});
		
		tests.add(new Test<List<Integer>>("remove") {
			
			@Override
			int test(List<Integer> container, TestParam param) {
				int loops = param.loops;
				int size = param.size;
				for(int i=0;i<loops;i++){
					container.clear();
					container.addAll(new CountingIntegerList(size));
					while(container.size()>5)
						container.remove(5);	//Minimize random-access costs
				}
				return loops*size;
			}
		});
		
		//tests for queue behavior
		qTests.add(new Test<LinkedList<Integer>>("addFirst") {
			
			@Override
			int test(LinkedList<Integer> container, TestParam param) {
				int loops = param.loops;
				int size = param.size;
				for(int i=0;i<loops;i++){
					container.clear();
					for(int j=0;j<size;j++)
						container.addFirst(47);
				}
				return loops*size;
			}
		});
		
		qTests.add(new Test<LinkedList<Integer>>("addLast") {
			
			@Override
			int test(LinkedList<Integer> container, TestParam param) {
				int loops = param.loops;
				int size = param.size;
				for(int i=0;i<loops;i++){
					container.clear();
					for(int j=0;j<size;j++)
						container.addLast(47);
				}
				return loops*size;
			}
		});
		
		
		qTests.add(new Test<LinkedList<Integer>>("removeFirst") {
			
			@Override
			int test(LinkedList<Integer> container, TestParam param) {
				int loops = param.loops;
				int size = param.size;
				for(int i=0;i<loops;i++){
					container.clear();
					container.addAll(new CountingIntegerList(size));
					while(container.size()>0)
						container.removeFirst();
				}
				return loops*size;
			}
		});
		
		
		qTests.add(new Test<LinkedList<Integer>>("removeLast") {
			
			@Override
			int test(LinkedList<Integer> container, TestParam param) {
				int loops = param.loops;
				int size = param.size;
				for(int i=0;i<loops;i++){
					container.clear();
					container.addAll(new CountingIntegerList(size));
					while(container.size()>0)
						container.removeLast();
				}
				return loops*size;
			}
		});
		
	}
	
	static class ListTester extends Tester<List<Integer>>{

		public ListTester(List<Integer> container,
				List<Test<List<Integer>>> tests) {
			super(container, tests);
		}
		
		@Override
		protected List<Integer> initialize(int size) {
			container.clear();
			container.addAll(new CountingIntegerList(size));
			return container;
		}
		
		public static void run(List<Integer> container,List<Test<List<Integer>>> tests){
			new ListTester(container, tests).timeTester();
		}
		
	}
	
	public static void main(String[] args) {
		if(args.length>0)
			Tester.defaultParams = TestParam.array(args);
		//can only do these two test on an array
		Tester<List<Integer>> arrayTester = new  Tester<List<Integer>>(null,tests.subList(1, 3)){
			@Override
			protected List<Integer> initialize(int size) {
				Integer[] ia = Generated.array(Integer.class, new CountingGenerator.Integer(),size);
				return Arrays.asList(ia);
			}
		};
		arrayTester.setHeadline("Array as List");
		arrayTester.timeTester();
		Tester.defaultParams = TestParam.array(10,5000,100,5000,1000,1000,10000,200);
		if(args.length>0)
			Tester.defaultParams = TestParam.array(args);
		ListTester.run(new ArrayList<Integer>(), tests);
		ListTester.run(new LinkedList<Integer>(), tests);	
		ListTester.run(new Vector<Integer>(), tests);
		Tester.fieldWidth = 12;
		Tester<LinkedList<Integer>> qTest = new Tester<LinkedList<Integer>>(new LinkedList<Integer>(), qTests);
		qTest.setHeadline("Queue tests");
		qTest.timeTester();
		
	}
	
}
