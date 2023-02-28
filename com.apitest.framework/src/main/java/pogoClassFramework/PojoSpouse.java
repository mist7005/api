package pogoClassFramework;

public class PojoSpouse {
	private String name;
	private long phnNo;
	
	public PojoSpouse()
	{
		
	}
	public PojoSpouse(String name,long phoNo)
	{
		
		this.name=name;
		this.phnNo=phoNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhnNo() {
		return phnNo;
	}

	public void setPhnNo(long phnNo) {
		this.phnNo = phnNo;
	}
	
	
}
