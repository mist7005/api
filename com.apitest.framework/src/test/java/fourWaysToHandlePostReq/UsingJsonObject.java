package fourWaysToHandlePostReq;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UsingJsonObject {
	@Test
	public void postUsingJsonObjectTest()
	{
		JSONObject jsonj=new JSONObject();
		jsonj.put("createdBy", "pk121");
		jsonj.put("projectName", "RestProjj175"+new Random().nextInt(500));
		jsonj.put("status", "On going");
		jsonj.put("teamSize", 5);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
			.body(jsonj)
			.contentType(ContentType.JSON)
			.when()
			.post("/addProject")
			.then()
			.statusCode(201)
			.log().all();
	}

}
