package avstract;

public abstract class Factory {
	abstract Headlight makeHeadlight();
	abstract Tire makeTire();
	public static Factory getFactoryType(String facType)
	{
		Factory factory = null;
		if (facType.equalsIgnoreCase("Mercedes"))
			factory = new MercedesFactory();
		else if(facType.equalsIgnoreCase("Audi"))
			factory = new AudiFactory();
		else
			System.out.println("Invalid factory type");
		return factory;
	}
}
