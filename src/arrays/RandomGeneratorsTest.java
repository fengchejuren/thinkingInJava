package arrays;

import utils.Generator;
import utils.RandomGenerator;

public class RandomGeneratorsTest {

//	public static int size = 10;
//	
//	public static void test(Class<?> surroundingClass) throws Exception{
//		for(Class<?> type : surroundingClass.getClasses()){
//			System.out.println(type.getSimpleName()+":");
//			Generator<?> g = (Generator<?>) type.newInstance();
//			for(int i=0;i<size;i++){
//				System.out.println(g.next()+" ");
//			}
//			System.out.println();
//		}
//	}
//	
	public static void main(String[] args) throws Exception {
		GeneratorsTest.test(RandomGenerator.class);
	}
	
}
