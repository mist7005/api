package practice;

import org.testng.annotations.Test;

public class Prac1 {

	String z="";
	StrEx ex;

	@Test(priority = 1)
	public void pT() {
		z="1234";
		System.out.println("value from PT===> "+Thread.currentThread().getId());
		ex=new StrEx(z);
		System.out.println("value from PT===> "+z);
		ThreadSafeEx.setProjectID(ex);
	}
	
	@Test(priority = 2)
	public void pT1() {
//		System.out.println(z);
		System.out.println("value from PT1===> "+Thread.currentThread().getId());
		System.out.println("value from PT1===> "+ex.getTxt());
	}

}
