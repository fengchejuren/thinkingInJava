package containers;

/**土拨鼠   与天气预报建立连接
 * @author Administrator
 *
 */
public class GroundHog {

	protected int number;
	
	public GroundHog(int n){
		this.number = n;
	}
	@Override
	public String toString() {
		return "GroundHog#"+number;
	}
	
}
