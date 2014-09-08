package com.webo.wizard.config;

import java.util.HashMap;
import java.util.Map;
import com.webo.annotations.Scope;

public class BeanFactory {
	static Object object;
	static String dumyString;
	static Map<String, Object> classMap = new HashMap<String, Object>();

	public static void addToMap(String key, Object object) {

		classMap.put(key, object);

	}

	public static Object retrFromMap(String classId) {

		if (classMap.containsKey(classId)) {
			
			object = classMap.get(classId);
			if (object.getClass().isAnnotationPresent(Scope.class))
				dumyString = object.getClass().getAnnotation(Scope.class)
						.value();
			else
				dumyString = "";
			
			 System.out.println(dumyString);

			if (dumyString.equalsIgnoreCase("Singleton")) {

				return classMap.get(classId);
			} else {

				try {
					
					return object.getClass().newInstance();
				} catch (InstantiationException | IllegalAccessException e) {

					e.printStackTrace();
				}
			}
		}

		return null;

	}

	public static boolean containsKey(String classId) {
		if (classMap.containsKey(classId))
			return true;
		else
			return false;

	}

}
