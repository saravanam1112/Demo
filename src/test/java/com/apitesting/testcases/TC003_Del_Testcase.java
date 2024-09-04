package com.apitesting.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apitesting.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_Del_Testcase extends BaseTest {

	@BeforeClass
	public void del() {
		
		RestAssured.baseURI="https://reqres.in/api";
		httpRequest = RestAssured.given();
		response= httpRequest.request(Method.DELETE, "/user/"+ empid);
		
	}
	
	@Test
	public void del_code() {
		
		int del_stscode= response.getStatusCode();
		Assert.assertEquals(del_stscode, 204);
	}
	
	
	
}