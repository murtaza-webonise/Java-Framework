package com.webo.wizard.config;

import java.util.*;
import java.util.Map.Entry;

public class HashClass {
	public static Map<String, String> hm = new HashMap<String, String>();
	Entry<String, String> dumyEntry;

	public void addToMap(String key, String value) {
		// value.substring(value.lastIndexOf(".") + 1, value.length());
		hm.put(key, value);

	}

	public Map<String, String> retrMap() {
		return hm;

	}

	public String retrFromMap(String value) {

		for (Entry<String, String> entry : hm.entrySet()) {
			// System.out.println(entry.getValue());
			if (entry
					.getValue()
					.substring(entry.getValue().lastIndexOf(".") + 1,
							entry.getValue().length()).equals(value)) {
				// System.out.println(entry.getKey());

				return entry.getKey();
			}
		}

		return null;

	}
}
