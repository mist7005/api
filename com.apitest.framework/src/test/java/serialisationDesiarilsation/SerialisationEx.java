package serialisationDesiarilsation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pogoClassFramework.NestedProject;
import pogoClassFramework.Project;

public class SerialisationEx {

	@Test
	public void serialiseTest() throws JsonGenerationException, JsonMappingException, IOException
	{
		Project p=new Project("hmarjk", "hmarTyss"+new Random().nextInt(), "On going", 3);
		
		Project p1=new Project("hmarjk", "hmarTyss"+new Random().nextInt(), "On going", 3);
		Project p2=new Project("amar", "hmarTyss"+new Random().nextInt(), "On going", 4);
		Project p3=new Project("hpamnkaj", "hmarTyss"+new Random().nextInt(), "On going", 10);
		
		List<Project> lp=new ArrayList<>();
		lp.add(p1);
		lp.add(p2);
		lp.add(p3);
		NestedProject np=new NestedProject();
		np.setnP(lp);

		ObjectMapper objM=new ObjectMapper();
		String nestedJsonPayload = objM.writerWithDefaultPrettyPrinter().writeValueAsString(lp);
		System.out.println(nestedJsonPayload);
//		objM.writeValue(new File("./jfile.json"), p);
//		objM.writeValue(new File("./nJs.json"),lp);



	}
	@Test
	public void deserialiseTest() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper objM1=new ObjectMapper();
		
		Project p1 = objM1.readValue(new File("./jfile.json"), Project.class);

		System.out.println("Created By  ====> "+p1.getCreatedBy());
		System.out.println("Project Name====> "+p1.getprojectName());
		System.out.println("Status      ====> "+p1.getstatus());
		System.out.println("Team Size   ====> "+p1.getteamSize());
	}
}
