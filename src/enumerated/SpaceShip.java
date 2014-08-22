/**
 * 
 */
package enumerated;

/**
 * @author Administrator
 *
 */
public enum SpaceShip {
	SCOUT,CARGO,TRANSPORT,CRUSOR,BATTLESHIP,MOTHLESHIP;
	public String toString() {
		String id = name();
		String lower = id.substring(1).toLowerCase();
		return id.charAt(0)+lower;
	};
	
	public static void main(String[] args) {
		for(SpaceShip s:SpaceShip.values()){
			System.out.println(s);
		}
	}
}
