package concurrency.section2;

public class LiftOff implements Runnable {

	protected int countdown = 10;
	private static int counttask = 0;
	private final int id = counttask++;
	public LiftOff(){}
	public LiftOff(int countdown){
		this.countdown = countdown;
	}
	
	public String status(){
		return "#"+id+":("+(countdown>0?countdown:"LiftOff")+")";
	}
	
	public void run() {
		while (countdown-->0) {
			System.out.println(status());
			Thread.yield();
		}
	}
	public static void main(String[] args) {
		LiftOff launch = new LiftOff();
		launch.run();
		
	}
	
	
}
