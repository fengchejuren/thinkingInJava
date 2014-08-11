package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**File类，既代表一个特定文件的名称，又可以代表一个目录下的一组文件的名称
 * 所以实际上它是一个文件路径：FilePath更适合作为它的类名
 * @author Administrator
 *
 */
public class DirList {

	public static void main(String[] args) {
		File path = new File(".");
		String[] list;
		if(args.length==0)
			list = path.list();
		else list = path.list(new DirFilter(args[0]));
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String fileItem:list)
			System.out.println(fileItem);
		
	}
	
	
	
}

/**DirFilter这个类的唯一用途是实现accept()方法，通过该方法判断有哪些文件包含在列表中
 * @author Administrator
 *
 */
class DirFilter implements FilenameFilter{
	private Pattern pattern;
	public DirFilter(String regex){
		pattern = Pattern.compile(regex);
	}
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return pattern.matcher(name).matches();
//		return true;
	}
	
}