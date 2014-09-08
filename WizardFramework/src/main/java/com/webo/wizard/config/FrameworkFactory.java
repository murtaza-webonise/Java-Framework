package com.webo.wizard.config;

import java.util.HashMap;
import java.util.Map;

public class FrameworkFactory {

	// Map<String, Object> classMap = new HashMap<String, Object>();

	private Object addr;

	public Object createFactoryClass(Class<?> dumy, String scope, String classId)
			throws InstantiationException, IllegalAccessException {

		if (scope.equalsIgnoreCase("Singleton")) {
			
			
			if (!BeanFactory.containsKey(classId)) {

				addr = dumy.newInstance();
				// System.out.println("me aya "+ classId);
				BeanFactory.addToMap(classId, addr);

				return addr;
			} else {
				

				addr = BeanFactory.retrFromMap(classId);
				
				return addr;
			}
		} else {

			addr = dumy.newInstance();

			BeanFactory.addToMap(classId, addr);

			return addr;
		}

	}

}
