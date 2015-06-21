package com.testworldweb.api.flickr;

import java.net.*;
import java.util.Iterator;
import java.io.*;

import org.json.*;
public class flickr {

	//18263654111
	/**
	 * @param photoId for which isPublic should be returned
	 * @return status of isPublic
	 * @throws Exception
	 */
	
	public static String getSharingforPhoto(String photoId) throws Exception {
		String inputLine;
		BufferedReader in;
		try{
			URL flickr = new URL("https://api.flickr.com/services/rest/?&method=flickr.photos.getInfo&api_key=6554114c9f2d497af1dd28cf45568380&photo_id="+photoId+"&format=json ");
			URLConnection fl = flickr.openConnection();
			in = new BufferedReader(
					new InputStreamReader(
							fl.getInputStream()));

			inputLine = in.readLine();
			System.out.println(inputLine);
			System.out.println("*********************");

		}

		catch(Exception e)
		{
			e.printStackTrace();
			return "no internet";

		}

		String amu=inputLine.substring(14, inputLine.length()-1);
		System.out.println(amu);
		in.close();

		try{
			JSONObject obj = new JSONObject(amu);
			
			System.out.println("KEYS----------"+obj.keys());
			//obj.k
			Iterator<String> ir=obj.keys(); 
			while(ir.hasNext())
			{
				String val=ir.next().toString();
				System.out.println(val);
				System.out.println(obj.get(val));
			}
			
			JSONObject photo=obj.getJSONObject("photo");
			JSONObject visibilty=photo.getJSONObject("visibility");

			int isPublic=visibilty.getInt("ispublic");
			System.out.println("visbility is "+isPublic);
			//String result=(String)isPublic;


			System.out.println("---");


			return Integer.toString(isPublic);
		}
		catch(JSONException e1){
			e1.printStackTrace();
			return "Picture not public";
		}
		catch(Exception e){
			e.printStackTrace();
			return "some other error";
		}


	}
	public static int sum(int a, int b)
	{
		return a+b;
	}
	public static void main(String[] args) throws Exception 
	{

		//String temp= getSharingforPhoto("18252638126");
		//System.out.println(temp);
		
		String temp1= getSharingforPhoto("18252636446");
		System.out.println(temp1);
		
	}
	
	
	
}




