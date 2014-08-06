package utils;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


public class CountingMapData extends AbstractMap<Integer, String>{

	private int size;
	private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ".split(" ");
	public CountingMapData(int size){
		if(size<0)
			this.size = 0;
		this.size = size;
	}
	private static class Entry implements Map.Entry<Integer, String>{

		int index;
		Entry(int index){
			this.index = index;
		}
		@Override
		public boolean equals(Object arg0) {
			// TODO Auto-generated method stub
			return Integer.valueOf(index).equals(arg0);
		}
		@Override
		public Integer getKey() {
			// TODO Auto-generated method stub
			return index;
		}

		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return chars[index%chars.length]+Integer.toString(index/chars.length);
		}

		@Override
		public String setValue(String value) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Integer.valueOf(index).hashCode();
		}
		
	}
	
	
	@Override
	public Set<java.util.Map.Entry<Integer, String>> entrySet() {
		// TODO Auto-generated method stub
		Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<Map.Entry<Integer,String>>();
		for(int i=0;i<size;i++){
			entries.add(new Entry(i));
		}
		return entries;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new CountingMapData(60));
	}

}
