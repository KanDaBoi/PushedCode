package avstract;

public class MercedesHeadlight extends Headlight{
	public Headlight constructHeadlight()
	{
		//System.out.println("Headlight for Mercedes model created");
		return new MercedesHeadlight();
	}
}
