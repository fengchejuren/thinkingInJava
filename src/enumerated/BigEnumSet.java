/**  
 * @Title: BigEnumSet.java 
 * @Package enumerated 
 * @Description: TODO 
 * @author Rock King 2014年8月23日 上午11:00:24
 * @version V1.0  
 */
package enumerated;

import java.util.EnumSet;

/**
 * EnumSet的基础是long,一个long是64位，而一个enum实例只能表示一个bit上的状态是否有值。
 * 那如果enum的实例超过了64个，会发生什么情况呢？ 答案是EnumSet会自动扩充，不会因为超过64位而发生异常
 * 
 * @Description: TODO
 * @author Rock King 2014年8月23日 上午11:00:24
 * @see ~!^ Keep bugs away and code with U!
 */

public class BigEnumSet {

	enum BigEnum {
		A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, 
		A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, 
		A21, A22, A23, A24, A25, A26, A27, A28, A29, A30,
		A31, A32, A33, A34, A35, A36, A37, A38, A39, A40,
		A41, A42, A43, A44, A45, A46, A47, A48, A49, A50,
		A51, A52, A53, A54, A55, A56, A57, A58, A59, A60, 
		A61, A62, A63, A64, A65, A66, A67, A68, A69, A70,
		A71, A72, A73, A74, A75, A76, A77, A78, A79, A80, 
		A81, A82, A83, A84, A85, A86, A87
	}
	
	public static void main(String[] args) {
		EnumSet<BigEnum> set = EnumSet.allOf(BigEnum.class);
		System.out.println(set);
	}
}
