package com.testworldweb.api.flickr;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("1", "A");
		hm.put("2", "B");
		hm.put("3", "C");
		hm.put("4", "D");
		System.out.println(hm.get("1"));
		
		hashmapIterator(hm);

boolean isEmpty = hm.isEmpty();
System.out.println("Is HashMap is empty: " + isEmpty);



hm.remove("1");

System.out.println("Printing the hash map list after the deletion");
hashmapIterator(hm);
hm.put("1", "A");
System.out.println("Printing the hash map list after the adding 'A' again");
hashmapIterator(hm);

	}//main ends
	
	
	static void hashmapIterator(HashMap<String, String> hm){
		Iterator<String> keySetIterator = hm.keySet().iterator();

		while(keySetIterator.hasNext()){
		  String key = keySetIterator.next();
		  System.out.println("key: " + key + " value: " + hm.get(key));
		}//while ends
	}//function ends

}//class ends
