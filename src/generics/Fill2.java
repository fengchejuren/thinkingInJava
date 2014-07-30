package generics;

interface Addable<T>{
	void add(T t);
}
public class Fill2 {

	public static <T> void fill(Addable<T> addable,Class<? extends T> classToken,int size){
		try {
			for(int i=0;i<size;i++){
				addable.add(classToken.newInstance());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
