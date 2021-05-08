package builderPattern;
import java.util.*;
public class BuilderPatternDemo {
	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello!! Welcome to Dine-And-Go! Would you like a veg or non-veg meal?");
		String choice = sc.nextLine();
		if(choice.equalsIgnoreCase("veg"))
		{
			Meal vegMeal = mealBuilder.prepareVegMeal();
			System.out.println("Veg Meal");
			vegMeal.showItems();
			System.out.println("Total Cost: " + vegMeal.getCost());
		}
		else if(choice.equalsIgnoreCase("non-veg"))
		{
			Meal nonvegMeal = mealBuilder.prepareNonVegMeal();
			System.out.println("Non Veg Meal");
			nonvegMeal.showItems();
			System.out.println("Total Cost: "+nonvegMeal.getCost());
		}
		sc.close();
	}
}
