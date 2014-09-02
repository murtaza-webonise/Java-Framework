import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.webo.annotations.Autoinit;

public class AnnotationScanner {
	public Class<?> dumyObj;

	public AnnotationScanner(Class<?> dumy) {
		dumyObj = dumy;
	}

	public void checkAnnotation() {

		Field[] fields = dumyObj.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Autoinit.class)) {
				Class<?> obj2 = field.getType();
				try {
					Annotation autoinit = field.getAnnotation(Autoinit.class);
					// Class obj3=autoinit.getClass();
					Autoinit ai = (Autoinit) autoinit;
					FrameworkFactory ff = new FrameworkFactory();
					
					//System.out.println(obj2.getName();
					Object key = (Object) ff.createFactoryClass(obj2, "bean");
					
					
					Method method = dumyObj.getMethod("set"+obj2.getSimpleName(), obj2);
				
					
					method.setAccessible(true);
					method.invoke(dumyObj.newInstance(), key);

				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
