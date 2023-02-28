package practice;


public class ThreadSafeEx {

	private static  ThreadLocal<StrEx> p=new ThreadLocal<StrEx>();
	
	public static StrEx getProjectID()
	{
		return p.get();
	}
	public static void setProjectID(StrEx pid)
	{
		p.set(pid);
	}
	
}
