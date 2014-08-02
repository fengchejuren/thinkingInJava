package utils;

import java.util.Random;

import arrays.CountingGenerator;

public class RandomGenerator {

	private static Random random = new Random(47);
	
	public static class Boolean implements Generator<java.lang.Boolean>{

		@Override
		public java.lang.Boolean next() {
			// TODO Auto-generated method stub
			return random.nextBoolean();
		}
		
	}
	
	public static class Byte implements Generator<java.lang.Byte>{
		
		@Override
		public java.lang.Byte next() {
			// TODO Auto-generated method stub
			return (byte) random.nextInt();
		}
		
	}

	public static class Character implements Generator<java.lang.Character>{
		
		@Override
		public java.lang.Character next() {
			return CountingGenerator.chars[random.nextInt(CountingGenerator.chars.length)];
		}
		
	}
	
	public static class String extends CountingGenerator.String{
		{cGenerator = new Character(); }
		
		public String(){}
		public String (int length){
			super(length);
		}
	}
	
	public static class Short implements Generator<java.lang.Short>{

		@Override
		public java.lang.Short next() {
			return (short)random.nextInt();
		}
		
	}

	public static class Integer implements Generator<java.lang.Integer>{
		private int mod = 10000;
		public Integer(){}
		public Integer(int modulo){
			this.mod = modulo;
		}
		@Override
		public java.lang.Integer next() {
			return random.nextInt(mod);
		}
		
	}
	
	public static class Long implements Generator<java.lang.Long>{
		private int mod = 10000;
		public Long(){}
		public Long(int modulo){
			this.mod = modulo;
		}
		@Override
		public java.lang.Long next() {
			return new java.lang.Long(random.nextInt(mod));
		}
		
	}
	
	public static class Float implements Generator<java.lang.Float>{
		
		@Override
		public java.lang.Float next() {
			//trim all but the first two decimal places
			int trimed = Math.round(random.nextFloat()*100);
			return ((float)trimed)/100;
		}
		
	}
	
	public static class Double implements Generator<java.lang.Double>{
		
		@Override
		public java.lang.Double next() {
			//trim all but the first two decimal places
			long trimed = Math.round(random.nextDouble()*100);
			return ((double)trimed)/100;
		}
		
	}
	
}
