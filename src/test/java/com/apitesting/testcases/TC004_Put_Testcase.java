package com.apitesting.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apitesting.base.BaseTest;
import com.apitesting.utilities.UtilityTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC004_Put_Testcase extends BaseTest {
	
	String empsalary=UtilityTest.empsal();
	String address= UtilityTest.address();
	
	@BeforeClass
	public void edit_data() {
		
		RestAssured.baseURI="https://reqres.in/api";
		httpRequest = RestAssured.given();
		JSONObject object= new JSONObject();
		
		object.put("Salary", empsalary);
		object.put("Address",address);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(object.toJSONString());

		
		response = httpRequest.request(Method.PUT, "/users/"+empid);
		
	}
	
	@Test
	public void stscode()
	{
		int code= response.getStatusCode();
		Assert.assertEquals(code, 200);
	}

	@Test
	public void body() {
		String resbody= response.getBody().asString();
		System.out.println(resbody);
		Assert.assertEquals(resbody.contains(address), true);
	}
	
	@Test
	public void time() {
		long updatetime= response.getTime();
		Assert.assertTrue(updatetime<2000);
	}
		
		
}
