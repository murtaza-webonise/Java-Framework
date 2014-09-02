import java.util.HashMap;
import java.util.Map;

import com.webo.beans.Address;

public class MyFactory {
	Map<String, Object> classMap = new HashMap<String, Object>();

	public Object createMyClass(Class<?> dumy, String id) {

		if (!classMap.containsKey(id)) {
			Address addr = null;
			try {
				addr = (Address) dumy.newInstance();
				
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
