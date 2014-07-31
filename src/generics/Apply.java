package generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class Apply {

	public static <T, S extends Iterable<? extends T>> void apply(S seq,
=======

public class Apply {

	public static <T, S extends Iterable<? extends T>> void Apply(S seq,
>>>>>>> db82709c9dc21dd648e5fa8bdb6c69315ca061b7
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

<<<<<<< HEAD
class Square extends Shape{ }

class FilledList<T> extends ArrayList<T>{
	public FilledList(Class<? extends T> type,int size){
		try {
			for(int i=0;i<size;i++){
				add(type.newInstance());
			}
		} catch (Exception e) {
			throw new RuntimeException();
		} 
	}
}

class ApplyTest {
	public static void main(String[] args) throws Exception{
		List<Shape> shapes = new ArrayList<Shape>();
		for(int i=0;i<10;i++)
			shapes.add(new Shape());
		Apply.apply(shapes, Shape.class.getMethod("rotate"));
		Apply.apply(shapes, Shape.class.getMethod("rotate", int.class), 5);
		List<Square> squares = new ArrayList<Square>();
		for(int i=0;i<5;i++){
			squares.add(new Square());
		}
		Apply.apply(squares, squares.getClass().getMethod("rotate"));
		Apply.apply(squares, Shape.class.getMethod("resize", int.class),5);
		Apply.apply(new FilledList<Shape>(Shape.class, 10),Shape.class.getMethod("rotate"));
		Apply.apply(new FilledList<Shape>(Square.class, 10),Shape.class.getMethod("rotate"));
		
	}
	
}
=======



>>>>>>> db82709c9dc21dd648e5fa8bdb6c69315ca061b7





