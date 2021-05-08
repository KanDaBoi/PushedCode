package adapterPattern;

public class MovableAdapterImpl implements MovableAdapter{
	private Movable luxuryCar; 
	public MovableAdapterImpl(Movable luxuryCar)
	{
		this.luxuryCar = luxuryCar;
	}
	@Override 
	public double getSpeed() 
	{ 
		return convertMPHtoKMPH(luxuryCar.getSpeed()); 
	} 
	private double convertMPHtoKMPH(double mph) 
	{ 
		return mph * 1.60934; 
	}
	public double getPrice()
	{
		return convertUSDtoEuro();
	}
	private double convertUSDtoEuro()
	{
		return 1900000*0.84;
	}
}
