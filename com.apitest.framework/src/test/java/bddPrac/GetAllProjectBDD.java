package bddPrac;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetAllProjectBDD {
	@Test
	public void getAllProjectTest()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		
		when()
		.get("/project")
		
		.then()
//		.assertThat()
//		.statusCode(200)
//		.contentType(ContentType.JSON)
//		.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		.log().all();
		
		
		
		
	}
}
