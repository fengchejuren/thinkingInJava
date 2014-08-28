/**
 * 
 */
package annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**注解处理器
 * 如果没有用来读取注解的工具，那么注解不会比注释更有用
 * 使用注解很重要的一个部分就是使用注解处理器
 * 这个方法是读取PasswordUtils，并使用反射机制查找@UseCase标记
 * @author Administrator
 *
 */
public class UseCaseTrackers {

	public static void trackUseCase(List<Integer> useCases,Class<?> cl){
		for(Method m:cl.getDeclaredMethods()){
			UseCase uc = m.getAnnotation(UseCase.class);
			if(uc!=null){
				System.out.println("get UseCase annotation "+uc.id()+" "+uc.descripting());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for(Integer integer:useCases){
			System.out.println("missing UseCase-"+integer);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases, 47,48,49,50);
		trackUseCase(useCases, PasswordUtils.class);
		
	}
}
