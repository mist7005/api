package validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicValidation {
	
	@Test
	public void dynamicTest()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		boolean found=false;
		String expId="TY_PROJ_9933";
		Response resp = when()
		.get("/projects");
		
		int j=0;
		List<String> proId=resp.jsonPath().get("projectId");
		
		for (String p : proId) {
			if(p.equalsIgnoreCase(expId))
			{
				found=true;
				break;
			}
		}
		Assert.assertTrue(found);
		System.out.println("data verified");
		
		for (int i = 0; i < proId.size(); i++) {
			String pID=proId.get(i);
			if(pID.equalsIgnoreCase("TY_PROJ_9873"))
			{
				System.out.println("the index is==> "+i);
				break;
			}
		}
		
		
	}
}
