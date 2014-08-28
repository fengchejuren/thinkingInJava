/**
 * 
 */
package annotation.dataBase;

/**
 * @author Administrator
 *
 */
@DBtable(name="MEMBER")
public class Member {
	@SQLString(30)
	String firstName;
	
	@SQLString(50)
	String lastName;
	
	@SQLInteger
	Integer age;
	
	@SQLString(value=30,constraints=@Constraints(primarkKey=true))
	String handle;
	
	static int numberCount;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public String getHandle() {
		return handle;
	}

	public static int getNumberCount() {
		return numberCount;
	}
	
	public String toString(){
		return handle;
	}
	
}
