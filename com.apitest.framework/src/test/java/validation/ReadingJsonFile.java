package validation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadingJsonFile {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser jsonparser=new JSONParser();
		
		FileReader reader=new FileReader(".\\trial.json");
		
		Object obj = jsonparser.parse(reader);
		
		JSONObject jsonObj = (JSONObject)obj;
		
		String page = (String)jsonObj.get("page").toString();
		System.out.println(page);
		
		JSONArray dataArray = (JSONArray)jsonObj.get("data");
		
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject data = (JSONObject)dataArray.get(i);
			System.out.println(data.get("name"));
		}
		
		
		
		
		
		
	}

}
