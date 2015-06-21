package com.testworldweb.api.flickr;

import java.net.*;
import java.util.HashMap;
import java.util.Iterator;
import java.io.*;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.*;

public class JsonComparisonJackson3 {

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
	public static void jsonDisplayJackson(String filename) throws JSONException, JsonProcessingException, IOException {
		

		ObjectMapper mapper = new ObjectMapper();
		System.out.println("filename"+filename);
			BufferedReader fileReader = new BufferedReader(new FileReader(filename));
			JsonNode rootNode = mapper.readTree(fileReader);
			printJson(rootNode,"");
		}

	
	
  static void printJson(JsonNode root,String prefix)
  {
	  
	  ObjectMapper mapper = new ObjectMapper();
	  
	  Iterator<String> itr=root.getFieldNames();
	  HashMap<String, String> hm = new HashMap<String, String>();;
	    while(itr.hasNext())
	    {
	      String tempKey=itr.next();
	      
	    	
	    	JsonNode value=root.get(tempKey);
	    	
	    	if(value.isValueNode()){
	    		String keyPath=prefix+"->"+tempKey;
	    	//	System.out.println(keyPath+":"+value);
	    	
	    		hm.put(keyPath,value.toString());
	    		//hm.remove(keyPath,value.toString());
	    		
	    		
	    	}
		    	
	    	if(value.isContainerNode())// if value is a json node
		    	{
		    		
		    		printJson(value,prefix+"->"+tempKey);
		    	}
	    }
	    
	    hashmapIterator(hm);
		
	  
  }
	public static void main(String[] args) throws Exception {

		//jsonDisplayJackson("one.json");
		jsonDisplayJackson("two1.json");
	
	}
	
	static void hashmapIterator(HashMap<String, String> hm){
		Iterator<String> keySetIterator = hm.keySet().iterator();

		while(keySetIterator.hasNext()){
		  String key = keySetIterator.next();
		  System.out.println("key: " + key + " value: " + hm.get(key));
		}//while ends
	}//function ends

	
}
