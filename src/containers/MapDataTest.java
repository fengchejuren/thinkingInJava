package containers;

import java.util.Iterator;

import arrays.CountingGenerator;
import utils.Generator;
import utils.MapData;
import utils.Pair;
import utils.RandomGenerator;

class Letters implements Generator<Pair<Integer, String>>,Iterable<Integer>{

	private int size = 9;
	private int number = 1;
	private char letter = 'A';
	
	@Override
	public Pair<Integer, String> next() {
		// TODO Auto-generated method stub
		return new Pair<Integer, String>(number++, ""+letter++);
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return number<size;
			}

			@Override
			public Integer next() {
				return number++;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	} 
	
}
public class MapDataTest {

	public static void main(String[] args) {
		System.out.println(MapData.map(new Letters(), 11));
		System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3),8));
		System.out.println(MapData.map(new CountingGenerator.Character(), "value",6));
		System.out.println(MapData.map(new Letters(),new RandomGenerator.String(3)));
		System.out.println(MapData.map(new Letters(), "POP"));
		
	}
}
