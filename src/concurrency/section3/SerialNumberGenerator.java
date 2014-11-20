package concurrency.section3;

public class SerialNumberGenerator {

	private volatile static int serialNumber = 0;
	public static int nextSerialNumber(){
		return serialNumber++;
	}
}
