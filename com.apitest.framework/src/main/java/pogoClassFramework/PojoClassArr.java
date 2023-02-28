package pogoClassFramework;

public class PojoClassArr {

	private String name;
	private int age;
	private long [] phoneNo;
	PojoSpouse spouse;
	
	public PojoClassArr()
	{
		
	}

	public PojoClassArr(String name,int age, long [] phoneNo,PojoSpouse sp)
	{
		this.name=name;
		this.age=age;
		this.phoneNo=phoneNo;
		this.spouse=sp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long[] getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long[] phoneNo) {
		this.phoneNo = phoneNo;
	}

	public PojoSpouse getSpouse() {
		return spouse;
	}

	public void setSpouse(PojoSpouse spouse) {
		this.spouse = spouse;
	}
	
	

}
