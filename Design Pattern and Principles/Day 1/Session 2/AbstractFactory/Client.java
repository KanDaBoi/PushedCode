package avstract;
import java.util.*;
public class Client {
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the One-Stop-Generator. Which factory would you like to access today?");
		String facType = sc.nextLine();
		Factory factory = Factory.getFactoryType(facType);
		if(factory != null)
		{
			System.out.println("Wonderful! We are all set up! Now, please wait while we craft and log the parts being created");
			Headlight headlight = factory.makeHeadlight();
			System.out.println(headlight);
			Tire tire = factory.makeTire();
			System.out.println(tire);
		}
		else
		{
			System.out.println("Sorry but we do not yet offer services for "+facType+". If it is indeed an actual factory type, we might add resources in the future. Check back in later!!!");	
		}
		sc.close();
	}
}
