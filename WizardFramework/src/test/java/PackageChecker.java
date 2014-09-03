import java.io.File;

public class PackageChecker {
	String packageName;
	String filePath;

	public PackageChecker(String packageName, String filePath) {
		this.packageName = packageName;
		this.filePath = filePath;

	}

	public PackageChecker() {
		// TODO Auto-generated constructor stub
	}

	public void checker() {
		
			
			try {
				Class<?> dumy=Class.forName(packageName+"."+filePath.substring(0, filePath.indexOf(".java")));
				System.out.println(dumy.getPackage());
				AnnotationScanner obj=new AnnotationScanner(dumy);
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
