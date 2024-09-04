package com.apitesting.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class UtilityTest {
	
	public static String empname()
	{
		String generateString= RandomStringUtils.randomAlphabetic(1);
		return("Sarav"+ generateString);
	}
	
	public static String empsal()
	{
		String generateString= RandomStringUtils.randomNumeric(5);
		return(generateString);
	}
	
	public static String empage()
	{
		String generateString= RandomStringUtils.randomNumeric(5);
		return(generateString);
	}
	
	public static String address() 
	{
		String genstr=RandomStringUtils.randomAlphabetic(3);
		return("Bangalore"+ genstr);
	}

}
