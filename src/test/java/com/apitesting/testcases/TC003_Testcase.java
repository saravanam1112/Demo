package com.apitesting.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apitesting.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC003_Testcase extends BaseTest {

	@BeforeClass
	public void del() {
		
		RestAssured.baseURI="https://reqres.in/api";
		httpRequest = RestAssured.given();
		response= httpRequest.request(Method.DELETE, "/empid");
		
	}
	
	@Test
	public void code() {
		
		int stscode= response.getStatusCode();
		Assert.assertEquals(stscode, 204);
	}
}
