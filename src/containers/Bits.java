/**  
 * @Title: BitSet.java 
 * @Package containers 
 * @Description: TODO 
 * @author Rock King 2014年8月9日 下午5:19:04
 * @version V1.0  
 */ 
package containers;

import java.util.BitSet;
import java.util.Random;

/** 如果想要高效率的存储大量"开关"信息,BitSet是很好的选择.不过它的高效率是相对于它占的存储空间而言.如果需要高效的访问时间,BitSet要
 * 比本地数组慢一点
 * @Description: TODO
 * @author Rock King 2014年8月9日 下午5:19:04 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class Bits {

	public static void printBitSet(BitSet bitSet){
		System.out.println("BitSet:"+bitSet);
		StringBuilder sbBuilder = new StringBuilder();
		for(int j=0;j<bitSet.size();j++)
			sbBuilder.append(bitSet.get(j)?1:0);
		System.out.println("bit pattern:\n"+sbBuilder);
		
	}
	
	public static void main(String[] args) {
		Random random = new Random(47);
		Byte byte1 = (byte) random.nextInt();
		byte1 = -107;
		BitSet bBitSet = new BitSet();
		for(int i=7;i>=0;i--){
			if(((1<<i) & byte1)!=0)
				bBitSet.set(i);
			else 
				bBitSet.clear(i);
		}
		printBitSet(bBitSet);
		System.out.println();
		
		short st = (short) random.nextInt();
		st = -107;
		BitSet sBitSet = new BitSet();
		for(int i=15;i>=0;i--){
			if(((1<<i)&st)!=0)
				sBitSet.set(i);
			else
				sBitSet.clear(i);
		}
		printBitSet(sBitSet);
		System.out.println();
		
		int it = random.nextInt();
		BitSet iBitSet = new BitSet();
		for(int i=31;i>=0;i++){
			if(((1<<i)&it)!=0)
				iBitSet.set(i);
			else
				iBitSet.clear(i);
		}
		//printBitSet(iBitSet);		//此处iBitSet不能打印,会报内存溢出 为什么呢???
		System.out.println();
		
		//test bitsets>=64bit
		BitSet b127 = new BitSet();
		b127.set(127);
		System.out.println("set bitset 127:"+b127);
		printBitSet(b127);
		System.out.println();
		BitSet b1024 = new BitSet();
		b127.set(1024);
		b1024.set(1000);
		printBitSet(b1024);
		
		
	}
}
