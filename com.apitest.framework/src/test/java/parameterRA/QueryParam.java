package parameterRA;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParam {

	@Test
	public void QueryParamTest()
	{
		baseURI="https://reqres.in/";
		given()
		.queryParam("page", 2)
		
		.when()
		.get("api/users/?page")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
}
