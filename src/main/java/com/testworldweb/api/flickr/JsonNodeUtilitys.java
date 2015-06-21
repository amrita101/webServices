package com.testworldweb.api.flickr;

import java.net.*;
import java.util.Iterator;
import java.util.List;
import java.io.*;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.*;

public class JsonNodeUtilitys {

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

	public static void jsonDisplayJackson(String filename) throws JSONException, JsonProcessingException, IOException {
		

		ObjectMapper mapper = new ObjectMapper();
		System.out.println("filename"+filename);
			BufferedReader fileReader = new BufferedReader(new FileReader(filename));
			JsonNode rootNode = mapper.readTree(fileReader);
			List<JsonNode> parentNodes0=rootNode.findParents("day");
			System.out.println(parentNodes0.toString());
			
			JsonNode dateNode=rootNode.get("date");
			System.out.println(dateNode.toString());
			List<JsonNode> parentNodes=dateNode.findParents("date");
			System.out.println(parentNodes.toString());
			
	}

	
	
  static void printJson(JsonNode root)
  {
	  
	  ObjectMapper mapper = new ObjectMapper();
	  
	  Iterator<String> fields=root.getFieldNames();
		
	    while(fields.hasNext())
	    {
	      String tempKey=fields.next();
	      
	    	System.out.println("Key is "+ tempKey);
	    	
	    	JsonNode value=root.get(tempKey);
	    	
	    	if(value.isValueNode()){
	    	
	    		System.out.println("    Value is"+value);
	    	}
		    	
	    	if(value.isContainerNode())// if value is a json node
		    	{
		    		
		    		printJson(value);
		    	}
	    }
	    //check if tempkey is also a json
	    
	    
	  
  }
	public static void main(String[] args) throws Exception {

		
		jsonDisplayJackson("two1.json");
	}

}
