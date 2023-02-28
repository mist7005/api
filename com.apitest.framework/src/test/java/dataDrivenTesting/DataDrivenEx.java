package dataDrivenTesting;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import pogoClassFramework.Project;

public class DataDrivenEx {

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][4];
		data[0][0]="grqs";
		data[0][1]="GrRmg123";
		data[0][2]="On going";
		data[0][3]=4;
		
		data[1][0]="grqs";
		data[1][1]="GrRmg1234";
		data[1][2]="On going";
		data[1][3]=3;
		
		data[2][0]="grqs";
		data[2][1]="GrRmg1235";
		data[2][2]="On going";
		data[2][3]=2;
		
		return data;

	}
	
	@DataProvider
	public Object[][] getDataJson() throws JsonParseException, JsonMappingException, IOException
	{
		Object[][] data=new Object[1][4];
		
		ObjectMapper objM=new ObjectMapper();
		Project p = objM.readValue(new File("./jfile.json"), Project.class);
		data[0][0]=p.getCreatedBy();
		data[0][1]=p.getprojectName()+new Random().nextInt(500);
		data[0][2]=p.getstatus();
		data[0][3]=p.getteamSize();
		return data;

	}
	
	@Test(dataProvider = "getDataJson")
	public void postReq(String createdBy,String projectName,String status,int teamSize)
	{
		Project p=new Project(createdBy, projectName, status, teamSize);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.body(p)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.statusCode(201)
		.log().all();
	}
}
