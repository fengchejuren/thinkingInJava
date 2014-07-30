package generics;

import java.lang.reflect.Method;

class Mime{
	public void walkAgainstWind(){ }
	public void sit(){
		System.out.println("Pretending to sit.");
	}
	public void pushInvisibleWalls(){ }
	@Override
	public String toString() {
		return "Mime";
	}
}
class SmartDog{
	public void speak(){
		System.out.println("Woof.");
	}
	public void sit(){
		System.out.println("Dog sit.");
	}
	public void reproduce(){ }
}
class CommunicateReflactively{
	public static void perform(Object speaker){
		Class<?> spk = speaker.getClass();
		try {
			try {
				Method sperker = spk.getMethod("speak");
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				System.out.println(speaker+ "can't speak...");
			}
			try {
				Method sit = spk.getMethod("sit");
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				System.out.println(speaker+ "can't sit...");
			}
		} catch (Exception e) {
			throw new RuntimeException(speaker.toString(),e);
		} 
	}
}
public class LatentReflaction {

	public static void main(String[] args) {
		CommunicateReflactively.perform(new SmartDog());
		CommunicateReflactively.perform(new Mime());
	}
}
