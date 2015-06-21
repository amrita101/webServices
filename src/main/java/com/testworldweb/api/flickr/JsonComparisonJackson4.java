package com.testworldweb.api.flickr;

import java.net.*;
import java.util.HashMap;
import java.util.Iterator;
import java.io.*;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.*;

public class JsonComparisonJackson4 {

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
	public static void jsonDisplayJackson(String filename,boolean addSubtract1) throws JSONException, JsonProcessingException, IOException {
		

		ObjectMapper mapper = new ObjectMapper();
		System.out.println("filename"+filename);
			BufferedReader fileReader = new BufferedReader(new FileReader(filename));
			JsonNode rootNode = mapper.readTree(fileReader);
			populateHash(rootNode,"",addSubtract1);
		}

	
	
  static void populateHash(JsonNode root,String prefix,boolean addSubtract2)
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
	    	if(addSubtract2==true){
	    		hm.put(keyPath,value.toString());
	    	}
	    	else{
	    	hm.remove(keyPath, value.toString());
	    	}
	    	}
	    		
	    	
		    	
	    	if(value.isContainerNode())// if value is a json node
		    	{
		    		
		    		populateHash(value,prefix+"->"+tempKey,addSubtract2);
		    	}
	    }
	    
	    hashmapIterator(hm);
		
	  
  }
	public static void main(String[] args) throws Exception {

		//jsonDisplayJackson("one.json");
		jsonDisplayJackson("two1.json",true);
		jsonDisplayJackson("two2.json",false);
	
	}
	
	static void hashmapIterator(HashMap<String, String> hm){
		Iterator<String> keySetIterator = hm.keySet().iterator();

		while(keySetIterator.hasNext()){
		  String key = keySetIterator.next();
		  System.out.println("key: " + key + " value: " + hm.get(key));
		}//while ends
	}//function ends

	
}
