package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	
	@Test
	public void deleteProject()
	{
		String projectId="TY_PROJ_9996";
		Response resp = RestAssured.delete("http://rmgtestingserver:8084/projects/"+projectId);
		resp.then().log().all();
		System.out.println(resp.getStatusCode());
	}

}
