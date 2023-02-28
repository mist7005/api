package fourWaysToHandlePostReq;

import static io.restassured.RestAssured.*;

import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.HashedMap;
import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class UsingHashMap {
	
	public void createProject()
	{
		//Step 1:  create pre-requesite
		Map<String, Object> mObj=new HashedMap<>();
		mObj.put("createdBy", "pk121");
		mObj.put("projectName", "RestProjq175"+new Random().nextInt(500));
		mObj.put("status", "On going");
		mObj.put("teamSize", 5);

		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.body(mObj)
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
