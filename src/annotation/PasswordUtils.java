/**
 * 
 */
package annotation;

import java.util.List;

/**
 * @author Administrator
 *
 */
public class PasswordUtils {

	@UseCase(id=47,descripting="Passwords must contains one numeric")
	public boolean validatePassword(String password){
		return password.matches("\\w*\\d\\w*");
	}
	
	@UseCase(id=48)
	public String encryptPassword(String password){
		return new StringBuilder(password).reverse().toString();
	}
	
	@UseCase(id=49,descripting="new password can't equals with previously used ones")
	public boolean checkForNewPassword(List<String> prePassword,String password){
		return !prePassword.contains(password);
	}
}
