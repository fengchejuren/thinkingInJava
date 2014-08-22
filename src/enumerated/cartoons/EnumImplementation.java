/**
 * 
 */
package enumerated.cartoons;

import java.util.Random;

import utils.Generator;

enum CartoonCharacter implements Generator<CartoonCharacter>{
	SLAPPY,SPANNY,PAUNCH,SILLY,PONY,NUTTY,BOB;

	private Random random = new Random(47);
	/* (non-Javadoc)
	 * @see utils.Generator#next()
	 */
	@Override
	public CartoonCharacter next() {
		// TODO Auto-generated method stub
		return values()[random.nextInt(values().length)];
	}
}
/**
 * @author Administrator
 *
 */
public class EnumImplementation {

	public static <T> void printNext(Generator<T> generator){
		System.out.print(generator.next()+", ");
	}
	
	public static void main(String[] args) {
		CartoonCharacter cartoon = CartoonCharacter.BOB;
		for(int i=0;i<10;i++){
			printNext(cartoon);
		}
		
		
		
	}
	
}
