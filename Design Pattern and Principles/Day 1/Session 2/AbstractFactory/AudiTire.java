package avstract;

public class AudiTire extends Tire{
	public Tire constructTire()
	{
		//System.out.println("Tire for Audi model created");
		return new AudiTire();
	}
}
