import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PropertyParser {

	String propertiesPath;
	JSONObject jsonObject;

	public void parser(String propertiesPath) {
		this.propertiesPath = propertiesPath;
		FileReader reader = null;
		try {
			reader = new FileReader(propertiesPath);
			JSONParser jsonParser = new JSONParser();

			jsonObject = (JSONObject) jsonParser.parse(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// get a String from the JSON object
		String packageName = (String) jsonObject.get("package-scan");
		System.out.println("package name is : " + packageName);
		String path="/home/webonise/workspace/WizardFrameworkTest/src/main/java/"+packageName.replace(".", "/");
		
		File f=new File(path);
		
		if (f.isDirectory()) {
			
			String s[] = f.list();
			for (int i=0; i < s.length; i++) {
			File f1 = new File(path + "/" + s[i]);
			if (f1.isDirectory()) {
			System.out.println(s[i] + " is a directory");
			} else {
			System.out.println(s[i] + " is a file");
			PackageChecker pc=new PackageChecker(packageName,s[i]);
			pc.checker();
			}
			}
			} else {
			System.out.println(path + " is not a directory");
			}
		

	}

}
