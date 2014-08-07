package containers;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class SpringDetector {

	public static <T extends GroundHog> void detectorSpring(Class<T> type) throws Exception{
		Constructor<T> gHog = type.getConstructor(int.class);
		Map<GroundHog, Prediction> map = new HashMap<GroundHog, Prediction>();
		for(int i=0;i<10;i++){
			map.put(gHog.newInstance(i), new Prediction());
		}
		System.out.println("map: "+map);
		GroundHog gHog2 = gHog.newInstance(3);
		System.out.println("looking up prediction for "+gHog2);
		if(map.containsKey(gHog2))
			System.out.println(map.get(gHog2));
		else {
			System.out.println(gHog2 +" not found!");
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		detectorSpring(GroundHog.class);
		System.out.println();
		System.out.println("二代土拨鼠来了》。。。。");
		detectorSpring(GroundHog2.class);
	}
}
