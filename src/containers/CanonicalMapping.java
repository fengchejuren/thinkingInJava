/**  
 * @Title: CanonicalMapping.java 
 * @Package containers 
 * @Description: TODO 
 * @author Rock King 2014年8月9日 上午11:56:37
 * @version V1.0  
 */
package containers;

import java.util.WeakHashMap;

/**
 * @Description: TODO
 * @author Rock King 2014年8月9日 上午11:56:37
 * @see ~!^ Keep bugs away and code with U!
 */

class Element {
	private String iden;

	public Element(String id) {
		this.iden = id;
	}

	/*
	 * (非 Javadoc) <p>Title: toString</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return iden;
	}

	/*
	 * (非 Javadoc) <p>Title: hashCode</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return iden.hashCode();
	}

	/*
	 * (非 Javadoc) <p>Title: equals</p> <p>Description: </p>
	 * 
	 * @param arg0
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return (arg0 instanceof Element) && (iden.equals(((Element) arg0).iden));
	}
	/* (非 Javadoc) 
	 * <p>Title: finalize</p> 
	 * <p>Description: </p> 
	 * @throws Throwable 
	 * @see java.lang.Object#finalize() 
	 */ 
	@Override
	protected void finalize() throws Throwable{
		super.finalize();
		System.out.println("Finalizing "+getClass().getSimpleName()+" "+iden);
	}
}

/** Key类必须有hashCode和equals(),因为在散列数据结构中,它被用作键
 * @Description: TODO
 * @author Rock King 2014年8月9日 下午12:12:46 
 * @see ~!^ Keep bugs away and code with U!	 
 */ 
class Key extends Element{

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param id 
	 */
	public Key(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
}
class Value extends Element{

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param id 
	 */
	public Value(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
}
public class CanonicalMapping {

	/** 运行此程序,就会发现,垃圾回收器每隔三个键就跳过一个,因为指向那个键的普通引用被指向了keys数组
	 * 所以那些对象不能被垃圾回收器回收
	 * @Description: TODO 
	 * @param args   
	 * void  
	 * @throws 
	 * @see Any changes please send mail to:superman166@126.com  
	 * ~!^ Keep bugs away and code with U!	
	 */
	public static void main(String[] args) {
		int size = 1000;
		if(args.length>0)
			size = Integer.valueOf(args[0]);
		Key[] keys = new Key[size];
		WeakHashMap<Key, Value> map = new WeakHashMap<Key,Value>();
		for(int i=0;i<size;i++){
			Key key = new Key(Integer.toString(i));
			Value value = new Value(Integer.toString(i));
			if(i%3==0)
				keys[i] = key;			//save as "real" references
			map.put(key, value);
		}
		System.out.println(map);
		System.gc();
		
	}
}
