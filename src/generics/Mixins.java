package generics;

import java.util.Date;

interface Timestamped {
	long getTimestamped();
}

class TimestampedImp implements Timestamped {

	private long timestame;

	public TimestampedImp() {
		timestame = new Date().getTime();
	}

	@Override
	public long getTimestamped() {
		// TODO Auto-generated method stub
		return timestame;
	}

}

interface SerialNumber {
	long getSerialNum();
}

class SerialNumberImp implements SerialNumber {

	private static long count = 1;
	private final long serialNum = count++;

	@Override
	public long getSerialNum() {
		// TODO Auto-generated method stub
		return serialNum;
	}

}

interface Basic {
	public void set(String val);

	public String get();
}

class BasicImp implements Basic {
	private String value;

	@Override
	public void set(String value) {
		this.value = value;
	}

	@Override
	public String get() {
		return value;
	}

}

class Mixin extends BasicImp implements SerialNumber, Timestamped {
	private Timestamped timestamped = new TimestampedImp();
	private SerialNumber serialNumber = new SerialNumberImp();

	@Override
	public long getTimestamped() {
		return timestamped.getTimestamped();
	}

	@Override
	public long getSerialNum() {
		return serialNumber.getSerialNum();
	}

}

/** 混型就是混个多个类的能力,以产生一个可以表示混型中所有类型的类
 * Java中经常使用接口来实现混型
 * @ClassName: Mixins 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Rock King
 * @date 2014年7月26日 上午10:23:37  
 */ 
public class Mixins {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 * @see Any changes please send mail to:superman166@126.com ~!~KEEP BUG AWAY
	 *      AND CODE WITH U!
	 */
	public static void main(String[] args) {
		Mixin mixin = new Mixin(), mixin2 = new Mixin();
		mixin.set("--test minxin1---");
		mixin2.set("--test minxin2---");
		System.out.println("mixin.get" + mixin.get() + " timestamp: "
						+ mixin.getTimestamped() + " serialNum:"
						+ mixin.getSerialNum());
		System.out.println("mixin2.get:" + mixin2.get() + " timestamp: "
				+ mixin2.getTimestamped() + " serialNum: "
				+ mixin2.getSerialNum());
	}
}
