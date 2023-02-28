package validation;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.testng.Assert;

import io.restassured.response.Response;


public class PostRegres {

	public static void main(String[] args) {

		Response resp = when()
				.get("https://reqres.in/api/unknown");


		ArrayList<Integer> dat = resp.jsonPath().get("data.id");
		boolean present = false;
		for (int i = 0; i < dat.size(); i++) {
			if(dat.get(i)==3)
			{
				present=true;
				break;
			}
		}
		Assert.assertTrue(present);
		System.out.println("pass");
	}

}
