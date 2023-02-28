package apiPracRegress;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApiTest {
	@Test
	public void apitest()
	{
		//		JSONObject ob=new JSONObject();
		//		ob.put("name", "morpheus");
		//		ob.put("job", "leader");
		baseURI="https://reqres.in/";
		//		Response resp =
		//				given()
		//		.body(ob)
		//		.contentType(ContentType.JSON)
		//
		//		.when()
		//			.post("/api/users");
		//		
		//		String expId = resp.jsonPath().get("id").toString();
		int expID=2;
		
		Response resp = 
		when()
		.get("/api/unknown")
		.then()
		.statusCode(200)
		.log().body()
		.extract().response();
		
//		.log().all();
		boolean found=false;
		List<Integer> idList=resp.jsonPath().get("data.id");
		for (int i = 0; i < idList.size(); i++) {
			if(idList.get(i)==expID)
			{
				found=true;
				break;
			}
		}
		Assert.assertTrue(found);
			
	}
}
