package bddPrac;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import practice.ProjectID;

public class GetSingleProjectBDD {
	@Test
	public void getSingleProjectTest()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when()
		.get("/projects/TY_PROJ_9933")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}
}
