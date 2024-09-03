package com.apitesting.base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;

import com.mongodb.diagnostics.logging.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;

import io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

	public static RequestSpecification httpRequest;
	public static Response response;
	public Logger logger;
	public String empid="380";
	
	
	
}
