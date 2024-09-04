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
	public void put_stscode()
	{
		int put_code= response.getStatusCode();
		Assert.assertEquals(put_code, 200);
	}

	@Test
	public void put_responsebody() {
		String put_resbody= response.getBody().asString();
		System.out.println(put_resbody);
		Assert.assertEquals(put_resbody.contains(address), true);
	}
	
	@Test
	public void put_responsetime() {
		long put_time= response.getTime();
		Assert.assertTrue(put_time<2000);
	}
		
		
}
