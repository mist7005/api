package parameterRA;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParamEx {

	@Test
	public void pathParamTest()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.pathParam("PID", "TY_PROJ_9933")
		
		.when()
		.get("/projects/{PID}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
}
