import java.util.HashMap;
import java.util.Map;


public class FrameworkFactory {

	Map<String, Object> classMap = new HashMap<String, Object>();
	
	private Object addr;
	public Object createFactoryClass(Class<?> dumy, String id) {
		
		
		if (!classMap.containsKey(id)) {
		try {
		
			addr = dumy.newInstance();
				
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			classMap.put(id, addr);

			return addr;
		} else {

			return classMap.get(id);
		}

	}

}
