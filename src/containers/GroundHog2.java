package containers;

public class GroundHog2 extends GroundHog{

	public GroundHog2(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return number;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof GroundHog && ((GroundHog)obj).number == number;
	}
	
	
	
	
}
