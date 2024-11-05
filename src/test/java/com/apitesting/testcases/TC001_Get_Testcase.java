package com.apitesting.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.apitesting.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class TC001_Get_Testcase extends BaseTest {
	
	@BeforeClass
	public void getdata() throws InterruptedException {
		
		RestAssured.baseURI="https://reqres.in/api";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/users?page=2");
		Thread.sleep(3000);
		
	}
	
	@Test(priority=1)
	public void get_statuscode() {
		
		int stscode=response.getStatusCode();
		System.out.println(stscode);
		Assert.assertEquals(stscode, 200);
	}
	
	@Test(priority=3)
	public void get_statusline() {
		
		String get_content=response.contentType();
		System.out.println(get_content);

		Assert.assertEquals(get_content, "application/json; charset=utf-8");
	}
	
	@Test(priority=2)
	public void get_body() {
		
		String get_body=response.getBody().asString();
		Assert.assertTrue(get_body!=null);
	}
	
	@Test(priority=4)
	public void get_responsetime() {
		long get_timing = response.getTime();
		Assert.assertTrue(get_timing<3000);
		
		if(get_timing>3000)
		{
			System.out.println("The response time is greater than 10000");
		}
		
	}
	
	@Test(priority=5)
	public void getheader() {
		
		Headers allheader= response.headers();
		
		for (Header head : allheader)
		{
			System.out.println(head.getName()+ "=" +head.getValue());
		}
		
	}
	

}