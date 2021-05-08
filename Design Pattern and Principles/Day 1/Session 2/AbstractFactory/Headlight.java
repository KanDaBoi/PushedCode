package avstract;

public abstract class Headlight {
	abstract Headlight constructHeadlight();

	@Override
	public String toString() {
		return "A brand new headlight has been created!";
	}
	
}