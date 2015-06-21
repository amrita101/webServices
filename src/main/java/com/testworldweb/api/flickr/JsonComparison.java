package com.testworldweb.api.flickr;

import java.net.*;
import java.util.Iterator;
import java.io.*;

import org.json.*;

public class JsonComparison {

	// 18263654111
	/**
	 * @param photoId
	 * for which isPublic should be returned
	 * @return status of isPublic
	 * @throws Exception
	 */
	public static String readFileText(String filename) throws IOException {
		FileReader fileOne = null;
		try {
			fileOne = new FileReader(filename);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader buffer = new BufferedReader(fileOne);
		String temp = buffer.readLine();
		StringBuffer sb = new StringBuffer();
		while (temp != null) {
			sb.append(temp);
			sb.append("\n");
			// System.out.println(temp);
			temp = buffer.readLine();

		}
		buffer.close();
		return sb.toString();

	}

	public static void jsonDisplay(String filename) throws JSONException {

		JSONObject obj = new JSONObject(filename);

		System.out.println("**********************");

		Iterator<String> iteratorKey = obj.keys();
		while (iteratorKey.hasNext()) {
			String val = iteratorKey.next().toString();
			System.out.println(val+" : "+obj.get(val));
		

		}

	}

	public static void main(String[] args) throws Exception {

		jsonDisplay(readFileText("one.json"));
		jsonDisplay(readFileText("two.json"));
	}

}
