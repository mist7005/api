package bddPrac;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	public void updateProjectTest()
	{
	String projectId = "TY_PROJ_9933";

	JSONObject jsonj=new JSONObject();
	jsonj.put("createdBy", "pk121");
	jsonj.put("projectName", "RestProj115666654");
	jsonj.put("status", "Completed");
	jsonj.put("teamSize", 5);
	
	baseURI="http://rmgtestingserver";
	port=8084;
	given()
	.body(jsonj)
	.contentType(ContentType.JSON)
	
	.when()
	.put("/projects/TY_PROJ_9933")
	
	.then()
	.assertThat()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
	
	}
	
}
