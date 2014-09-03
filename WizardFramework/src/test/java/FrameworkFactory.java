import java.util.HashMap;
import java.util.Map;

public class FrameworkFactory {

	Map<Class<?>, Object> classMap = new HashMap<Class<?>, Object>();

	private Object addr;

	public Object createFactoryClass(Class<?> dumy, String scope)
			throws InstantiationException, IllegalAccessException {

		if (scope.equalsIgnoreCase("Singleton")) {
			if (!classMap.containsKey(dumy)) {
				
				addr = dumy.newInstance();

				classMap.put(dumy, addr);

				return addr;
			} else {

				return classMap.containsKey(dumy);
			}
		} else

			return dumy.newInstance();

	}

}
