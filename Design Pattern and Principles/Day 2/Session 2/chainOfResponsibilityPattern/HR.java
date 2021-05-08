package corPattern;

public class HR extends ILeaveRequestHandler{
	protected ILeaveRequestHandler nextHandler = null;//TODO: Create a setNextHandler method if extended beyond HR
	public void handleRequest(LeaveRequest request)
	{
		int leaveDays = request.getLeaveDays();
		if(leaveDays>5)
		{
			if(request.getEmployeeName().contains("007"))
				System.out.println("Leave approved by HR!!");
			else
				System.out.println("Leave not approved by HR!!");
		}
		if(this.nextHandler != null)
			this.nextHandler.handleRequest(request);
	}
}
