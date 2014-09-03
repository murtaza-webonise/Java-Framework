import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.webo.annotations.Autoinit;
import com.webo.annotations.Scope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnnotationScanner {
	public Class<?> dumyObj;
	static FrameworkFactory ff = new FrameworkFactory();
	// private static int counter=0;
	Object ob = null;
	String scopeValue;
	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(AnnotationScanner.class);

	public AnnotationScanner(Class<?> dumy) throws InstantiationException,
			IllegalAccessException {
		dumyObj = dumy;

		if (dumyObj.isAnnotationPresent(Scope.class)) {

			ob = (Object) ff.createFactoryClass(dumyObj,
					dumyObj.getAnnotation(Scope.class).value());

		} else
			ob = dumyObj.newInstance();
	}

	public void checkAnnotation() {

		Field[] fields = dumyObj.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Autoinit.class)) {
				Class<?> obj2 = field.getType();
				try {
					// Annotation autoinit =
					// field.getAnnotation(Autoinit.class);

					// Autoinit ai = (Autoinit) autoinit;
					if (obj2.isAnnotationPresent(Scope.class))
						scopeValue = obj2.getAnnotation(Scope.class).value();
					else
						scopeValue = "";

					Object key = (Object) ff.createFactoryClass(obj2,
							scopeValue);

					Method method = dumyObj.getMethod(
							"set" + obj2.getSimpleName(), obj2);

					method.setAccessible(true);
					method.invoke(ob, key);

				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					slf4jLogger.error(e.getMessage());
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					slf4jLogger.error(e.getMessage());
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					slf4jLogger.error("Dummy error message.");
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					slf4jLogger.error("Dummy error message.");
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					slf4jLogger.error("Dummy error message.");
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					slf4jLogger.error("Dummy error message.");
				}
			}
		}
	}

}
