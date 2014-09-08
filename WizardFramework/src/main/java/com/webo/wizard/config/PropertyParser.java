package com.webo.wizard.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PropertyParser {

	String propertiesPath;
	JSONObject jsonObject;
	String packageName, path, classId;
	File file;
	HashClass hc = new HashClass();
	HashMap<String, String> test = new HashMap<String, String>();
	PackageChecker pc;

	public PropertyParser() {

	}

	public void parser(String propertiesPath) {
		this.propertiesPath = propertiesPath;
		FileReader reader = null;
		try {
			reader = new FileReader(propertiesPath);
			JSONParser jsonParser = new JSONParser();

			jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray packagesName = (JSONArray) jsonObject.get("package-scan");
			Iterator<?> it = packagesName.iterator();
			while (it.hasNext()) {
				JSONObject innerObj = (JSONObject) it.next();
				packageName = innerObj.get("value").toString();
				classId = innerObj.get("id").toString();
				/*System.out.println("id " + classId + " with package "
						+ packageName);*/
				hc.addToMap(classId, packageName);
			}

			test = (HashMap<String, String>) hc.retrMap();
			Iterator<Entry<String, String>> iterator = test.entrySet()
					.iterator();
			while (iterator.hasNext()) {
				Entry<String, String> ob = iterator.next();
				classId = ob.getKey();
				packageName = ob.getValue();

				// path = "/home/webonise/workspace/WebSuperApp/src/"
				// + packageName.replace(".", "/");
				// file = new File(path);
				//System.out.println(packageName + " " + classId);
				pc = new PackageChecker(packageName, classId);
				pc.checker();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

		// get a String from the JSON object

	}
}
