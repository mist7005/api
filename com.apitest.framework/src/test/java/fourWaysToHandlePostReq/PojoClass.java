package fourWaysToHandlePostReq;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pogoClassFramework.Project;

import static io.restassured.RestAssured.*;

public class PojoClass {

	@Test
	public void createBojoObj() throws JsonGenerationException, JsonMappingException, IOException
	{
		Project p=new Project("qwerty1212","qwert567"+new Random().nextInt(500),"On going",4);
		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.writeValue(new File("./projectDetails.json"), p);
		String projectJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(p);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.body(projectJson)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		
		.then()
		.statusCode(201)
		.log().all();
	}
	
	
	public void postUsingPojoObj()
	{
		File f=new File("./projectDetails.json");
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.body(f)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		
		.then()
		.statusCode(201)
		.log().all();
	}
	
		
	}

