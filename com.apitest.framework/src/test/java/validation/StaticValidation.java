package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StaticValidation {

	@Test
	public void staticTest()
	{
	baseURI="http://rmgtestingserver";
	port=8084;
	
	String expId="TY_PROJ_9933";
	Response resp = when()
	.get("/projects");
	

	String proId=resp.jsonPath().get("[13265].projectId");
	Assert.assertEquals(expId, proId);
	System.out.println("data verified");
}
	
	
	
	
}
