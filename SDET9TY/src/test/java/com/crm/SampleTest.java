package com.crm;

import org.testng.annotations.Test;

public class SampleTest {
	@Test
	public void createContactTest() {
		System.out.println("execute createContactTest");
		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
	
		
	}

}
