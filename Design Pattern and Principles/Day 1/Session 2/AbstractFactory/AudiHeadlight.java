package avstract;

public class AudiHeadlight extends Headlight{
	public Headlight constructHeadlight()
	{
		//System.out.println("Headlight for Audi model created");
		return new AudiHeadlight();
	}
}
