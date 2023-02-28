package bddPrac;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class DeleteProject {
	@Test
	public void DeleteProjectTest()
	{
		String projectId = "TY_PROJ_16336";

		baseURI="http://rmgtestingserver";
		port=8084;
		
		when()
		.delete("/projects/TY_PROJ_16336")

		.then()
		.assertThat()
		.statusCode(204)
		.log().all();

	}
}
