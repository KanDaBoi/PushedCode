package adapterPattern;
import java.util.Scanner;
public class Client {
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		Movable buggatiVeyron = new BuggatiVeyron();
		System.out.println("Hello!!Would you like to see the top speed in KMPH or MPH?");
		String choice = sc.nextLine();
		if(choice.equalsIgnoreCase("MPH"))
		{
			System.out.println("The speed is "+ buggatiVeyron.getSpeed()+" MPH!");
			System.out.println("The price is $ 1.9 Million USD" );
		}
		else
		{
			MovableAdapterImpl convBuggati = new MovableAdapterImpl(buggatiVeyron);
			System.out.println("The speed is "+convBuggati.getSpeed()+" KMPH!");
			System.out.printf("The price is € %.2f Million",(convBuggati.getPrice()/1000000));
		}
		sc.close();
	}
}
