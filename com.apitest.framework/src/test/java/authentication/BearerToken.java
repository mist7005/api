package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
	@Test
	public void bearerTokenTest()
	{
		baseURI="https://api.github.com";
		JSONObject jOb=new JSONObject();
		
		jOb.put("name", "restAssuredToken");
		
		given()
		.auth()
		.oauth2("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")
		.body(jOb)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		
		.then()
		.log()
		
		.all();
	}
}
