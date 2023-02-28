package serialisationDesiarilsation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pogoClassFramework.PojoClassArr;
import pogoClassFramework.PojoSpouse;

public class SerialisationUsingArr {
	@Test
	public void arrTest() throws JsonGenerationException, JsonMappingException, IOException
	{
		long ar[]= {9987689,1267379};
		PojoSpouse sp=new PojoSpouse("pankaj", 1234567);
		
		
		PojoClassArr pjA=new PojoClassArr("abhi", 26, ar,sp);
		
		ObjectMapper obj=new ObjectMapper();
		obj.writeValue(new File("./nestedArr"), pjA);
		String nested = obj.writerWithDefaultPrettyPrinter().writeValueAsString(pjA);
		System.out.println(nested);
		
		
		
		
	}
}
