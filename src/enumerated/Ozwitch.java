/**
 * 
 */
package enumerated;

/**
 * @author Administrator
 *
 */
public enum Ozwitch {
	WEST("Miss Goss,aka the wicked witch of the West"),
	NORTH("Glube,aka the good witch of the North"),
	EAST("the Witch of the East,wearer of the Rubby Slippers,crushed by Dorothy's house"),
	SOUTH("Good by Interrence,But missing");
	private String desc;
	private Ozwitch(String desc){
		this.desc = desc;
	}
	public String getDesc(){
		return desc;
	}
	public static void main(String[] args) {
		for(Ozwitch o:Ozwitch.values()){
			System.out.println(o+" : "+o.getDesc());
		}
	}
	
	
}
