package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetSingleProject {
	@Test
	public void singleProject()
	{
				String projectId = "TY_PROJ_9933";
				Response resp = RestAssured.get("http://rmgtestingserver:8084/projects/"+projectId);
				resp.then().log().all();
				int actStatus=resp.getStatusCode();
				Assert.assertEquals(200, actStatus);
		//		ProjectID pi=new ProjectID();
		//		System.out.println(ProjectID.getPId());

		System.out.println("value from StrEx===> "+Thread.currentThread().getId());
		System.out.println("z value from StrEx class====>"+ThreadSafeEx.getProjectID().getTxt());
	}
}

