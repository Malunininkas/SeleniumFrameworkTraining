package tests;

import org.testng.annotations.Test;

import amazon.AmazonBase;

public class test extends AmazonBase {

	@Test()
	public void test1(){
		logger.debug("1");
	}
	
	@Test()
	public void test2(){
		logger.debug("2");
	}
		
	@Test()
	public void test3(){
		logger.debug("3");
	}
}

