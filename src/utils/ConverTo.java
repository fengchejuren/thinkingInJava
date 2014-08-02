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

}
