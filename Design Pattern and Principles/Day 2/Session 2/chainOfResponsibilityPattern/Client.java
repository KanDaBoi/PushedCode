package corPattern;
import java.util.Scanner;
public class Client {
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome! Please insert your id appended employee name!");
		String employeeName = sc.nextLine();
		System.out.println("Please enter the number of days you will be on leave!");
		int leaveDays = sc.nextInt();
		LeaveRequest request = new LeaveRequest(employeeName,leaveDays);
		ILeaveRequestHandler requestHandler = new Supervisor();
		System.out.println(requestHandler);
		requestHandler.handleRequest(request);
		sc.close();
	}
}
