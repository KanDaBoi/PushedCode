package avstract;

public class MercedesTire extends Tire{
	public Tire constructTire()
	{
		//System.out.println("Tire for Mercedes model created");
		return new MercedesTire();
	}
}
