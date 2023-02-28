package bddPrac;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostBDD {
	@Test
	public void createProject()
	{
		//Step 1:  create pre-requesite
		JSONObject jsonj=new JSONObject();
		jsonj.put("createdBy", "pk121");
		jsonj.put("projectName", "RestProj175"+new Random().nextInt(500));
		jsonj.put("status", "On going");
		jsonj.put("teamSize", 5);

		baseURI="http://rmgtestingserver";
		port=8084;
		String id="";
		given()
		.body(jsonj)
		.contentType(ContentType.JSON)

		//Step 2 perform action
		.when()
		.post("/addProject")

		//Step 3 validation
		.then()
		.assertThat()
		.statusCode(201)
		.body("msg", Matchers.equalTo("Successfully Added"))
		
		.contentType(ContentType.JSON)
		.log().all();
		

	}
}
