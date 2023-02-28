package dataDrivenTesting;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import pogoClassFramework.Project;

public class RequestChaining {
	
	@Test
	public void requestChainingTest()
	{
		Project p=new Project("khumar", "khuRmg"+new Random().nextInt(500), "On going", 3);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		Response res = given()
		.body(p)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject");
		
		String iD=res.jsonPath().get("projectId");
		System.out.println("id is ===> "+iD);
		
		// get the project
		given()
		.pathParam("Path", iD)
		.when()
		.get("/projects/{Path}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
		//update the project
		p.setstatus("completed");
		given()
		.body(p)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/projects/"+iD)
		.then()
		.statusCode(200)
		.log().all();
		
		//delete the project
		when()
		.delete("/projects/"+iD)
		.then()
		.statusCode(204);
		
	}
}
