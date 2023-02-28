package fourWaysToHandlePostReq;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingExternalFile {
	@Test
	public void postUsingExFile()
	{
		File file=new File("./src/test/java/fourWaysToHandlePostReq/j.json");
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.body(file)
		.contentType(ContentType.JSON)

		//Step 2 perform action
		.when()
		.post("/addProject")

		//Step 3 validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();

		
	}

}
