package day1Session1;
import java.util.*;
public class Main {
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		String productDetail;
		System.out.println("Welcome to our site. Would you like to order or repair?");
		String option = sc.nextLine();
		switch(option)
		{
			case "order":
				System.out.println("Please provide the phone model name");
				productDetail = sc.nextLine();
				Order order = new Order();
				order.processOrder(productDetail);
				break;
			case "repair":
				System.out.println("Is it the phone or the accessory that you want to be repaired?");
				String productType = sc.nextLine();
				if(productType.equalsIgnoreCase("Phone"))
				{
					System.out.println("Please provide the phone model name");
					productDetail = sc.nextLine();
					PhoneRepair pr = new PhoneRepair();
					pr.processPhoneRepair(productDetail);
				}
				else if(productType.equalsIgnoreCase("Accessory"))
				{
					System.out.println("Please provide the accessory detail,like headphone,tempered glass");
					productDetail = sc.nextLine();
					AccessoryRepair ar = new AccessoryRepair();
					ar.processAccessoryRepair(productDetail);
				}
				else
					System.out.println("Sorry. We don't fix that here!");
				break;
			default:
				System.out.println("Invalid choice.");
		}
		sc.close();
	}
}
