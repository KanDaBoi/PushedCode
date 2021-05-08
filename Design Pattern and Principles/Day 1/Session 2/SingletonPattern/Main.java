package day1Session2;

public class Main {
	public static void main(String []args)
	{
		DBConn conn = DBConn.getInstance();
		System.out.println("The singleton instance is "+ conn);
	}
}
