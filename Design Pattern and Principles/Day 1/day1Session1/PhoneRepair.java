package day1Session1;

public class PhoneRepair implements IPhoneRepair {
	private String phoneModel;
	public void setPhoneModel(String phoneModel)
	{
		this.phoneModel = phoneModel;
	}
	public String getPhoneModel()
	{
		return this.phoneModel;
	}
	public void processPhoneRepair(String model)
	{
		System.out.println(model+" repair accepted");
	}
}	
