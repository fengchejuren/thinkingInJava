package generics;

interface Addable<T>{
	void add(T t);
}
/** 适配器仿真潜在类型方式
 * @ClassName: Fill2 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Rock King
 * @date 2014年7月31日 下午8:42:38  
 */ 
public class Fill2 {

	/** 
	 * @Description: TODO 
	 * @param addable
	 * @param classToken
	 * @param size   
	 * @return void  
	 * @throws 
	 * @see Any changes please send mail to:superman166@126.com  
	 * ~!^KEEP BUG AWAY AND CODE WITH U!	
	 */
	public static <T> void fill(Addable<T> addable,Class<? extends T> classToken,int size){
		try {
			for(int i=0;i<size;i++){
				addable.add(classToken.newInstance());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> void fill(Addable<T> addable){}
}
