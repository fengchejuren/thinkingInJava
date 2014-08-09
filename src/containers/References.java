/**  
 * @Title: References.java 
 * @Package containers 
 * @Description: TODO 
 * @author Rock King 2014年8月9日 上午11:22:07
 * @version V1.0  
 */ 
package containers;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/** 
 * @Description: TODO
 * @author Rock King 2014年8月9日 上午11:22:07 
 * @see ~!^ Keep bugs away and code with U!	 
 */

class VeryBig{
	private static final int SIZE = 10000;
	private long[] la = new long[SIZE];
	private String ident;
	public VeryBig(String id){
		ident = id;
	}
	/* (非 Javadoc) 
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#toString() 
	 */ 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ident;
	}
	
	/* (非 Javadoc) 
	 * <p>Title: finalize</p> 
	 * <p>Description: </p> 
	 * @throws Throwable 
	 * @see java.lang.Object#finalize() 
	 */ 
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize:"+ident);
	}
} 
public class References {

	private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();
	
	public static void checkQueue(){
		Reference<? extends VeryBig> inq = rq.poll();
		if(inq!=null)
			System.out.println("In queue:"+inq.get());
	}
	
	public static void main(String[] args) {
		int size = 10;
		if(args.length>0)
			size = new Integer(args[0]);
		LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();
		for(int i=0;i<size;i++){
			sa.add(new SoftReference<VeryBig>(new VeryBig("Soft"+i),rq));
			System.out.println("Just created: "+sa.getLast());
			checkQueue();
		}
		
		LinkedList<WeakReference<VeryBig>> wa = new LinkedList<WeakReference<VeryBig>>();
		for(int i=0;i<size;i++){
			wa.add(new WeakReference<VeryBig>(new VeryBig("Weak:"+i),rq));
			System.out.println("Just created: "+wa.getLast());
			checkQueue();
		}
		
		SoftReference<VeryBig> s = new SoftReference<VeryBig>(new VeryBig("Soft"));
		WeakReference<VeryBig> w = new WeakReference<VeryBig>(new VeryBig("Weak"));
		System.gc();
		LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<PhantomReference<VeryBig>>();
		for(int i=0;i<size;i++){
			pa.add(new PhantomReference<VeryBig>(new VeryBig("Phantom "+i), rq));
			System.out.println("Phantom created: "+pa.getLast());
			checkQueue();
		}
		
		System.out.println("weakList中的对象引用是否为空:"+wa.get(2).get());
		
	}
	
}
