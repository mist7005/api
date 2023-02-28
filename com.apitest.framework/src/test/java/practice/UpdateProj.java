package practice;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProj {

	@Test
	public void updateProjTest()
	{
		String projectId = "TY_PROJ_16189";

		JSONObject jsonj=new JSONObject();
		jsonj.put("createdBy", "pk121");
		jsonj.put("projectName", "RestProj115666654");
		jsonj.put("status", "completed");
		jsonj.put("teamSize", 5);
		
		RequestSpecification req = RestAssured.given();
		req.body(jsonj);
		req.contentType(ContentType.JSON);

		Response resp = req.put("http://rmgtestingserver:8084/projects/TY_PROJ_16189");
		resp.then().log().all();
		System.out.println(resp.getStatusCode());
		System.out.println(resp.asString());
		System.out.println(resp.prettyPeek());
		
	}


}
