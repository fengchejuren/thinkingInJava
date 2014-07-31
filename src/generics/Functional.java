package generics;

import java.awt.image.RescaleOp;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

interface Combiner <T>{
	T combine(T x,T y);
}
interface UnaryFunction<T,R>{
	R function(T x);
}
interface Colloctor<T> extends UnaryFunction<T, T>{
	T result();
}
interface UnaryPreditate<T>{
	boolean test(T t);
}
/** 
 * @Description: TODO
 * @author Rock King 2014年7月31日 下午11:20:18 
 * ~!^ Keep bugs away and code with U!	 
 */ 
public class Functional {

	public static <T> T reduce(Iterable<T> seq,Combiner<T> combiner){
		Iterator<T> iterator = seq.iterator();
		if(iterator.hasNext()){
			T result = iterator.next();
			while(iterator.hasNext())
				result = combiner.combine(result, iterator.next());
			return result;
		}
		return null;
	}
	
	public static <T> Colloctor<T> forEach(Iterable<T> seq,Colloctor<T> func){
		for(T t:seq){
			func.function(t);
		}
		return func;
	}
	

	/**
	 * transform(方法的作用)
	 * (方法适用条件 – 可选)
	 * @param seq
	 * @param func
	 * @return 
	 *List<R>
	 * @exception 
	 * @author Rock King
	 * @see Any changes please send mail to:superman166@126.com  
	 * @since  1.0.0  ~!^ Keep bugs away and code with U!
	*/
	public static <R,T> List<R> transform(Iterable<T> seq,UnaryFunction<T, R> func){
		List<R> result = new ArrayList<R>();
		for(T t:seq){
			result.add(func.function(t));
		}
		return result;
	}
	
	public static <T> List<T> filter(Iterable<T> seq,UnaryPreditate<T> pre){
		List<T> result = new ArrayList<T>();
		for(T t:seq){
			if(pre.test(t))
				result.add(t);
		}
		return result;
	}
	
	static class IntegerAdder implements Combiner<Integer>{

		@Override
		public Integer combine(Integer x, Integer y) {
			// TODO Auto-generated method stub
			return x+y;
		}
		
	}
	
	static class IntegerSubtracter implements Combiner<Integer>{

		@Override
		public Integer combine(Integer x, Integer y) {
			// TODO Auto-generated method stub
			return x-y;
		}
		
	}
	
	static class BigDecimalAdder implements Combiner<BigDecimal>{

		@Override
		public BigDecimal combine(BigDecimal x, BigDecimal y) {
			// TODO Auto-generated method stub
			return x.add(y);
		}
		
	}
	
	static class BigIntegerAdder implements Combiner<BigInteger>{

		@Override
		public BigInteger combine(BigInteger x, BigInteger y) {
			// TODO Auto-generated method stub
			return x.add(y);
		}
		
	}
	
	static class AtomicLongAdder implements Combiner<AtomicLong>{

		@Override
		public AtomicLong combine(AtomicLong x, AtomicLong y) {
			// TODO Auto-generated method stub
			return new AtomicLong(x.addAndGet(y.get()));
		}
		
	}
	
	static class BigdecimalUlp implements UnaryFunction<BigDecimal,BigDecimal>{

		@Override
		public BigDecimal function(BigDecimal x) {
			// TODO Auto-generated method stub
			return x.ulp();
		}
		
	}
	
	static class GreaterThan<T extends Comparable<T>> implements UnaryPreditate<T>{

		private T bound;
		public GreaterThan(T bound){
			this.bound = bound;
		}
		@Override
		public boolean test(T t) {
			return t.compareTo(bound) > 0;
		}
		
	}
	
	static class MultiplyingIntegerCollector implements Colloctor<Integer>{
		private Integer val = 1;

		@Override
		public Integer function(Integer x) {
			val *= x;
			return val;
		}

		@Override
		public Integer result() {
			// TODO Auto-generated method stub
			return val;
		}
	}
	 
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		Integer result = reduce(list, new IntegerSubtracter());
		System.out.println(result);
		
		result = reduce(list, new IntegerAdder());
		System.out.println(result);
		
		System.out.println(filter(list, new GreaterThan<Integer>(4)));
		
		System.out.println(forEach(list, new MultiplyingIntegerCollector()).result());
		
		MathContext context = new MathContext(7);
		List<BigDecimal> bigDecimals = Arrays.asList(new BigDecimal(1.1,context),new BigDecimal(2.2,context),
				new BigDecimal(3.3,context),new BigDecimal(4.4,context));
		BigDecimal rbd = reduce(bigDecimals, new BigDecimalAdder());
		System.out.println(rbd);
		
		System.out.println(filter(bigDecimals, new GreaterThan<BigDecimal>(new BigDecimal(3))));
		
		List<BigInteger> lbIntegers = new ArrayList<BigInteger>();
		BigInteger bInteger = BigInteger.valueOf(11);
		for(int i=0;i<11;i++){
			lbIntegers.add(bInteger);
			bInteger = bInteger.nextProbablePrime();
		}
		System.out.println(lbIntegers);
		
		BigInteger rbInteger = reduce(lbIntegers, new BigIntegerAdder());
		System.out.println(rbInteger);
		System.out.println(rbInteger.isProbablePrime(5));
		
		
		List<AtomicLong> alt = Arrays.asList(new AtomicLong(11),new AtomicLong(47),
				new AtomicLong(74),new AtomicLong(133));
		AtomicLong red = reduce(alt, new AtomicLongAdder());
		System.out.println(red);
		
		System.out.println(transform(bigDecimals, new BigdecimalUlp()));
		
	}
}

