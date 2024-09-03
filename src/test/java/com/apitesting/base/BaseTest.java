package com.apitesting.base;

import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

	public static RequestSpecification httpRequest;
	public static Response response;
	public String empid="380";
		
}
