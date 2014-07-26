package generics;

import java.util.ArrayList;
import java.util.List;

interface Processor<T, E extends Exception> {
	void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
	List<T> processAll() throws E {
		List<T> resultCollector = new ArrayList<T>();
		for (Processor<T, E> processor : this) {
			processor.process(resultCollector);
		}
		return resultCollector;
	}
}

class Failurel extends Exception {
}

class Process1 implements Processor<String, Failurel> {
	static int count = 3;

	@Override
	public void process(List<String> resultCollector) throws Failurel {
		if (count-- > 1) {
			resultCollector.add("hep!");
		} else {
			resultCollector.add("ho");
		}
		if (count < 0) {
			throw new Failurel();
		}
	}

}

class Failure2 extends Exception {
}

class Process2 implements Processor<Integer, Failure2> {
	static int count = 3;

	@Override
	public void process(List<Integer> resultCollector) throws Failure2 {
		if (count-- == 0) {
			resultCollector.add(47);
		} else {
			resultCollector.add(11);
		}
		if(count<0){
			throw new Failure2();
		}
	}

}

/** 由于擦除的原因,将泛型应用于异常是非常受限制的
 * 但是,类型参数可以在一个方法的throw字句中用到,这使得你可以编写随检查型异常而发生变化的代码
 * @ClassName: ThrowGenericException 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Rock King
 * @date 2014年7月26日 上午9:38:10  
 */ 
public class ThrowGenericException {

	public static void main(String[] args) {
		ProcessRunner<String, Failurel> process1 = new ProcessRunner<String,Failurel>();
		for(int i=0;i<3;i++){
			process1.add(new Process1());
		}
		try {
			System.out.println(process1.processAll());
		} catch (Failurel e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProcessRunner<Integer, Failure2> process2 = new ProcessRunner<Integer,Failure2>();
		for(int i=0;i<3;i++){
			process2.add(new Process2());
		}
		try {
			System.out.println(process2.processAll());
		} catch (Failure2 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
