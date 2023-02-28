package practice;

import java.lang.reflect.Field;

import org.testng.annotations.Test;

public class StrEx {
	String b;
	public StrEx(String g)
	{
		b=g;
		
	}
	public String getTxt()
	{
		return b;
		
	}
	@Test
	public void test3(){
		
//		String z="helo \"my name\" \"TY_PROJ_16336\"";
//		System.out.println(z.replace("\"", ""));
//		Prac1 p=new Prac1();
		
		System.out.println("value from StrEx===> "+Thread.currentThread().getId());
		System.out.println("z value from StrEx class====>"+ThreadSafeEx.getProjectID().getTxt());
//				p.setPId("5688");
//				System.out.println(ThreadSafeEx.getProjectID());
				
//				Class<?> cls = Class.forName("practice.ProjectID");
//				Field field = cls.getDeclaredField("pId");
//				field.setAccessible(true);
//				Object object = field.get(new ProjectID());
//				String result = (String) object;
//				System.out.println(result);
		
	}

}
