package com.webo.wizard.config;

public class PackageChecker {

	String filePath;
	String classId;

	public PackageChecker(String filePath, String classId) {

		this.filePath = filePath;
		this.classId = classId;

	}

	public PackageChecker() {
		// TODO Auto-generated constructor stub
	}

	public void checker() {

		try {
			Class<?> dumy = Class.forName(filePath);
			//System.out.println(dumy.getPackage());
			AnnotationScanner obj = new AnnotationScanner(dumy, classId);
			obj.checkAnnotation();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
