package containers;

public class AssociativeArray<K,V> {
	private Object[][] pairs;
	private int index;
	public AssociativeArray(int length){
		pairs = new Object[length][2];
	}

	public void put(K key,V value){
		if(index>pairs.length)
			throw new IndexOutOfBoundsException();
		pairs[index++] = new Object[]{key,value};
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key){
		for(int i=0;i<pairs.length;i++){
			if(key.equals(pairs[i][0]))
				return (V) pairs[i][1];
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		for(int i=0;i<index;i++){
			sBuilder.append(pairs[i][0].toString());
			sBuilder.append(" : ");
			sBuilder.append(pairs[i][1].toString());
			if(i<index-1)
				sBuilder.append("\n");
		}
		return sBuilder.toString();
	}
	
	public static void main(String[] args) {
		AssociativeArray<String, String> map = new AssociativeArray<String, String>(6);
		map.put("sky", "blue");
		map.put("grass", "green");
		map.put("tree", "tall");
		map.put("earth", "brown");
		map.put("ocean", "dancing");
		map.put("sun", "warm");
//		try {
//			map.put("extra", "object");
//		} catch (Exception e) {
//			System.out.println("too many elements");
//		}
		System.out.println(map);
		System.out.println(map.get("ocean"));
		
	}
	
	
}
