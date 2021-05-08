package day1Session1;

public class AccessoryRepair implements IAccessoryRepair {
	private String accessoryType;
	public void setAccessoryType(String accessoryType)
	{
		this.accessoryType = accessoryType;
	}
	public String getAccessoryType()
	{
		return this.accessoryType;
	}
	public void processAccessoryRepair(String accessoryType)
	{
		System.out.println(accessoryType+" repair accepted");
	}
}
