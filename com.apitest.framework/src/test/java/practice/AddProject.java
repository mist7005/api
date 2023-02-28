package practice;

import java.util.Random;

import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class AddProject {
	private String pId="";
	public RequestSpecification repB;
	@BeforeClass
	public void t1()
	{

		RequestSpecBuilder spb=new RequestSpecBuilder();
		spb.setContentType(ContentType.JSON);
		spb.setBasePath("/addProject");
		 repB= spb.build();
	}
	@Test
	public void postEg() {
		JSONObject jsonj=new JSONObject();
		jsonj.put("createdBy", "pk121");
		jsonj.put("projectName", "RestProj15"+new Random().nextInt(500));
		jsonj.put("status", "On going");
		jsonj.put("teamSize", 5);


//		RequestSpecification req = RestAssured.given();
//		req.body(jsonj);
//		req.contentType(ContentType.JSON);
//
//		Response response = req.post("http://rmgtestingserver:8084/addProject");
		
		
		repB.body(jsonj);
		
//		
		Response resp = repB.post();
		System.out.println(resp.getBody());


//	String bd = response.asString();
//	pId=bd.split(",")[3].split(":")[1];
//	pId=pId.replaceAll("\"", "");
//	System.out.println(pId.replaceAll("\"", ""));
//	String z="helo \"my name\" ";
//	System.out.println(z.replace("\"", ""));
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getBody());
//		System.out.println(response.getTime());
//		System.out.println(response.getContentType());
//		System.out.println(response.asString());
//		System.out.println(response.prettyPrint());
//		System.out.println(response.prettyPeek());

	}
	
	
	
	public void singleProject()
	{
				String projectId = pId;
				Response resp = RestAssured.get("http://rmgtestingserver:8084/projects/"+projectId);
				resp.then().log().all();
				int actStatus=resp.getStatusCode();
				Assert.assertEquals(200, actStatus);
		//		ProjectID pi=new ProjectID();
		//		System.out.println(ProjectID.getPId());

//		System.out.println("value from StrEx===> "+Thread.currentThread().getId());
//		System.out.println("z value from StrEx class====>"+ThreadSafeEx.getProjectID().getTxt());
	}
	
	public void selectDropDown(String s,WebElement e) {}
	public void selectDropDown(WebElement e,String s) {}
	

}
