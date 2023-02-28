package serialisationDesiarilsation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pogoClassFramework.PojoClassArr;

public class DeserialisationComplex {
	@Test
	public void testComplex() throws JsonParseException, JsonMappingException, IOException
	{
		
		ObjectMapper obj=new ObjectMapper();
		 PojoClassArr nestedRead = obj.readValue(new File("./nestedArr"), PojoClassArr.class);
		 System.out.println(nestedRead.getName());
		
	}
}
