package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author Administrator
 *
 */
public class DirList2 {

	public static FilenameFilter file(final String regex){
		return new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				Pattern pattern = Pattern.compile(regex);
				return pattern.matcher(name).matches();
			}
		};
		
	}
	
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
