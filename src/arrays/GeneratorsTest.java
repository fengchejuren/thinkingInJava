package arrays;

import utils.Generator;

public class GeneratorsTest {

	public static int size = 10;
	
	public static void test(Class<?> surroundingClass) throws Exception{
		for(Class<?> type : surroundingClass.getClasses()){
			System.out.println(type.getSimpleName()+":");
			Generator<?> g = (Generator<?>) type.newInstance();
			for(int i=0;i<size;i++){
				System.out.print(g.next()+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		test(CountingGenerator.class);
	}
	
}
