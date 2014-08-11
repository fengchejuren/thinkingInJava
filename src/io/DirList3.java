package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @author Administrator
 *
 */
public class DirList3 {

	public static void main(final String[] args) {
		File path = new File(".");
		String[] list;
		if(args.length==0)
			list = path.list();
		else
			list = path.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile(args[0]);
				@Override
				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches();
				}
			});
		for(String fileItem:list)
			System.out.println(fileItem);
		
	}
}
