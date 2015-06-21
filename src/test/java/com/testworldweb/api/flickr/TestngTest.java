package com.testworldweb.api.flickr;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngTest {


  @Test
  public void testSum() {
    Assert.assertEquals(5, flickr.sum(2, 3));
  }
}


