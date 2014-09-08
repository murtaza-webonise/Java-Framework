package com.webo.wizard.config;

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
	HashClass hc = new HashClass();
	// private static int counter=0;
	Object ob = null;
	String scopeValue;
	String classId;
	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(AnnotationScanner.class);

	public AnnotationScanner(Class<?> dumy, String classId)
			throws InstantiationException, IllegalAccessException {
		dumyObj = dumy;
		this.classId = classId;

		if (dumyObj.isAnnotationPresent(Scope.class)) {

			ob = ff.createFactoryClass(dumyObj,
					dumyObj.getAnnotation(Scope.class).value(), classId);

		} else {

			ob = ff.createFactoryClass(dumyObj, "Prototype", classId);
		}
	}

	public void checkAnnotation() {

		Field[] fields = dumyObj.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Autoinit.class)) {
				Class<?> obj2 = field.getType();
				try {
					// Annotation autoinit =
					// field.getAnnotation(Autoinit.class);

					classId = hc.retrFromMap(obj2.getSimpleName());
					// System.out.println(classId);
					// Autoinit ai = (Autoinit) autoinit;
					if (obj2.isAnnotationPresent(Scope.class))
						scopeValue = obj2.getAnnotation(Scope.class).value();
					else
						scopeValue = "";

					Object key = ff.createFactoryClass(obj2, scopeValue,
							classId);

					Method method = dumyObj.getMethod(
							"set" + obj2.getSimpleName(), obj2);

					method.setAccessible(true);
					// System.out.println("Mei hu murtaza ");

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
