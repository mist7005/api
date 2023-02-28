package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2 {
	@Test
	public void Oauth2Test()
	{		
		Response resp = given()
				.formParam("client_id", "ExRestAssured")
				.formParam("client_secret", "46930c79ff2cf99d88ce870c42941cb1")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "http://example.com")
				.formParam("code", "authorization_code")

				.when()
				.post("http://coop.apps.symfonycasts.com/token");

		//Capture the access token from the response of the above request
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
 
		//Create another request and use the token to access the APIs
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 4199)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")

		.then().log().all();
		
		
	}

}
