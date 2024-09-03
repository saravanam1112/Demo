package com.apitesting.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apitesting.base.BaseTest;
import com.apitesting.utilities.UtilityTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Testcase extends BaseTest{
	
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
	public void statuscode() {
		int stscode= response.getStatusCode();
		Assert.assertEquals(stscode, 201);
		
	}

	@Test
	public void body() {
		String resbody= response.getBody().asString();
		System.out.println(resbody);
		Assert.assertEquals(resbody.contains(empname1), true);
	}
}
