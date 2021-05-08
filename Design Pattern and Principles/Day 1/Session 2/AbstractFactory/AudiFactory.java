package avstract;

public class AudiFactory extends Factory{
	public Headlight makeHeadlight()
	{
		System.out.println("Creating a headlight for Audi");
		Headlight audiHeadlight = new AudiHeadlight().constructHeadlight();
		return audiHeadlight;
	}
	public Tire makeTire()
	{
		System.out.println("Creating a tire for Audi");
		Tire audiTire = new AudiTire().constructTire();
		return audiTire;
	}
}
