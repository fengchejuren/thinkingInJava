package generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Apply {

	public static <T, S extends Iterable<? extends T>> void Apply(S seq,
			Method f, Object... arg) {
		try {
			for (T t : seq)
				f.invoke(t, arg);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

class Shape{
	public void rotate(){
		System.out.println(this+" rotate.");
	}
	public void resize(int newSize){
		System.out.println(this+" resize "+newSize);
	}
}









