package parameterRA;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class FormParam {

	@Test
	public void FormParamTest()
	{	
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.param("createdBy", "kumar2.0")
		.param("projectName", "kumar1231")
		.param("status", "On going")
		.param("size", 4)
		.when()
		.post("/addProject")

		.then()
		.assertThat()
		.statusCode(201)
		.body("msg", Matchers.equalTo("Successfully Added"))
		
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}
}
