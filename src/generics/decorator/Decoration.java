package generics.decorator;

import java.util.Date;

class Basic {
	private String value;

	public String get() {
		return value;
	}

	public void set(String value) {
		this.value = value;
	}
}

class Decorator extends Basic {
	protected Basic basic;

	public Decorator(Basic basic) {
		this.basic = basic;
	}

	public String get() {
		return basic.get();
	}

	public void set(String value) {
		basic.set(value);
	}
}

class Timestamp extends Decorator {

	private final long timestamp;

	public Timestamp(Basic basic) {
		super(basic);
		timestamp = new Date().getTime();
	}

	public long getTimestamp() {
		return timestamp;
	}
}

class SerialNumbered extends Decorator {
	private static long count;
	private final long serialNumber = count++;

	public SerialNumbered(Basic basic) {
		super(basic);
	}

	public long getSerialNumber() {
		return serialNumber;
	}

}

/** 装饰器模式与混型模式
 * 装饰器模式使用分层对象来动态透明的向单个对象添加责任
 * @ClassName: Decoration 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Rock King
 * @date 2014年7月26日 上午11:25:24  
 */ 
public class Decoration {

	/** 
	 * @Title: main 
	 * @Description: TODO 
	 * @param @param args   
	 * @return void  
	 * @throws 
	 * @see Any changes please send mail to:superman166@126.com
	 * ^!~ KEEP BUG AWAY AND CODE WITH U! 
	 */
	public static void main(String[] args) {
		Timestamp timestamp = new Timestamp(new Basic());
		Timestamp timestamp2 = new Timestamp(new SerialNumbered(new Basic()));
		SerialNumbered serialNumbered = new SerialNumbered(new Basic());
		SerialNumbered serialNumbered2 = new SerialNumbered(new Timestamp(
				new Basic()));
		System.out.println(serialNumbered.getSerialNumber()+" "+serialNumbered2.get());
		
	}
}
