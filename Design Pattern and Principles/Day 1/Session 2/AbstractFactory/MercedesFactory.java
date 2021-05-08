package avstract;

public class MercedesFactory extends Factory{
	public Headlight makeHeadlight()
	{
		System.out.println("Creating a headlight for Mercedes");
		Headlight mercHeadlight = new MercedesHeadlight().constructHeadlight();
		return mercHeadlight;
	}
	public Tire makeTire()
	{
		System.out.println("Creating a tire for Mercedes");
		Tire mercTire = new MercedesTire().constructTire();
		return mercTire;
	}
}
