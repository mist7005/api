package apiPracRegress;

import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ApiTestRegGet {

	@Test
	public void test_GetSingle()
	{
		baseURI="https://reqres.in/";
		
		given()
		.when()
			.get("api/users/2")
		.then()
		.log().body()
		.statusCode(200)
		.body("data.id",equalTo(2))
		.body("data.email", equalTo("janet.weaver@reqres.i n"))
		.body("data.first_name", equalTo("Janet"))
		.body("data.last_name", equalTo("Weaver"));
	}
}
