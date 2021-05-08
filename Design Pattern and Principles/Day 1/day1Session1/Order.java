package day1Session1;

public class Order implements IPhoneOrder {
	private String model;
	public void setModel(String model)
	{
		this.model = model;
	}
	public String getModel()
	{
		return this.model;
	}
	public void processOrder(String model)
	{
		System.out.println(model+" order accepted!");
	}
}
