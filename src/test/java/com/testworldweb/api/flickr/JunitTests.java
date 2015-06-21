package com.testworldweb.api.flickr;


import  org.junit.Assert;
import org.junit.Test;

public class JunitTests {
	   
	   @Test
	   public void testSum() {	    
		   Assert.assertEquals(5,flickr.sum(3, 2));          
	   }
	   
	   @Test
	   public void testPublicPhoto() throws Exception {	    
		   Assert.assertEquals("Picture not public",flickr.getSharingforPhoto("18252638126"));          
	   }
	   @Test
	   public void testPublicPhoto1() throws Exception {	    
		   Assert.assertEquals("1",flickr.getSharingforPhoto("18252636446"));          
	   }
	   @Test
	   public void testSum3() {	    
		   Assert.assertEquals(5,flickr.sum(3, 2));          
	   }

} 
