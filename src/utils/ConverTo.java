package utils;

/** 
 * @Description: 将封装对象的数据自动转换成基本类型数据
 * @author Rock King 2014年8月2日 上午11:38:26 
 * ~!^ Keep bugs away and code with U!	 
 */ 
public class ConverTo {
	public static boolean[] primitive(Boolean[] in){
		boolean[] result = new boolean[in.length];
		for(int i=0;i<result.length;i++)
			result[i] = in[i];
		return result;
	}
	
	public static char[] primitive(Character[] in){
		char[] result = new char[in.length];
		for(int i=0;i<result.length;i++)
			result[i] = in[i];
		return result;
	}
	
	public static byte[] primitive(Byte[] in){
		byte[] result = new byte[in.length];
		for(int i=0;i<result.length;i++)
			result[i] = in[i];
		return result;
	}
	
	public static short[] primitive(Short[] in){
		short[] result = new short[in.length];
		for(int i=0;i<result.length;i++)
			result[i] = in[i];
		return result;
	}
	
	public static int[] primitive(Integer[] in){
		int[] result = new int[in.length];
		for(int i=0;i<result.length;i++)
			result[i] = in[i];
		return result;
	}
	
	public static long[] primitive(Long[] in){
		long[] result = new long[in.length];
		for(int i=0;i<result.length;i++)
			result[i] = in[i];
		return result;
	}
	
	public static double[] primitive(Double[] in){
		double[] result = new double[in.length];
		for(int i=0;i<result.length;i++)
			result[i] = in[i];
		return result;
	}
	
	public static float[] primitive(Float[] in){
		float[] result = new float[in.length];
		for(int i=0;i<result.length;i++)
			result[i] = in[i];
		return result;
	}

}
