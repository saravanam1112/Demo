package com.apitesting.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.apitesting.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class TC001_Testcase extends BaseTest {
	
	@BeforeClass
	public void getdata() throws InterruptedException {
		
		RestAssured.baseURI="https://reqres.in/api";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/users?page=2");
		Thread.sleep(3000);
		
	}
	
	@Test
	public void statuscode() {
		
		int stscode=response.getStatusCode();
		Assert.assertEquals(stscode, 200);
	}
	
	@Test
	public void statusline() {
		
		String content=response.contentType();
		Assert.assertEquals(content, "application/json; charset=utf-8");
	}
	
	@Test
	public void getbody() {
		
		String body=response.getBody().asString();
		Assert.assertTrue(body!=null);
	}
	
	
	

}
