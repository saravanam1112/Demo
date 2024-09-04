package com.apitesting.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apitesting.base.BaseTest;
import com.apitesting.utilities.UtilityTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Post_Testcase extends BaseTest{
	
	String empname1 = UtilityTest.empname();
	String empsalary= UtilityTest.empsal();
	String empAge= UtilityTest.empage();

	
	@BeforeClass
	public void updatedata() {
		
		RestAssured.baseURI="https://reqres.in/api";
		httpRequest = RestAssured.given();
		
		JSONObject obj= new JSONObject();
		
		obj.put("name", empname1);
		obj.put("Salary", empsalary);
		obj.put("age", empAge);

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(obj.toJSONString());
		
		response= httpRequest.request(Method.POST, "/users");
		
	}
	
	@Test
	public void post_statuscode() {
		int post_stscode= response.getStatusCode();
		Assert.assertEquals(post_stscode, 201);
		
	}

	@Test
	public void post_responsebody() {
		String post_resbody= response.getBody().asString();
		System.out.println(post_resbody);
		Assert.assertEquals(post_resbody.contains(empname1), true);
	}
	
	@Test
	public void post_responsetime() {
		long post_timing = response.getTime();
		Assert.assertTrue(post_timing<1000);
		
		if(post_timing>2000)
		{
			System.out.println("The response time is greater than 10000");
		}
}
}