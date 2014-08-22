/**
 * 
 */
package enumerated;

enum Signal {
	RED, GREEN, YELLOW
}

/**
 * @author Administrator
 * 
 */
public class TrafficLight {

	Signal color = Signal.RED;

	public void change() {
		switch (color) {
		//note that you don't have to say Signal.RED in the statement
		case RED:
			color = Signal.GREEN;
			break;
		case GREEN:
			color = Signal.YELLOW;
			break;
		case YELLOW:
			color = Signal.RED;
			break;
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "the Light is "+color;
	}
	public static void main(String[] args) {
		TrafficLight t = new TrafficLight();
		for(int i=0;i<10;i++){
			t.change();
			System.out.println(t);
		}
	}
}
