package utils;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {

	public static String pformat(Collection<?> c) {
		if(c.size()==0) return "[]";
		StringBuilder builder = new StringBuilder("[");
		for(Object o:c){
			if(c.size()!=1)
				builder.append("\n ");
			builder.append(o);
		}
		if(c.size()!=1)
			builder.append("\n");
		builder.append("]");
		return builder.toString();
	}
	
	public static void pprint(Collection<?> c){
		System.out.println(pformat(c));
	}

	public static void pprint(Object[] objects){
		System.out.println(pformat(Arrays.asList(objects)));
	}
	
}
