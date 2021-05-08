package corPattern;

public class ProjectManager extends ILeaveRequestHandler {
	protected ILeaveRequestHandler nextHandler;
	private void setNextHandler(ILeaveRequestHandler nextHandler)
	{
		this.nextHandler = nextHandler;
	}
	public void handleRequest(LeaveRequest request)
	{
		int leaveDays = request.getLeaveDays();
		if(leaveDays>=3 && leaveDays<=5)
		{
			if(request.getEmployeeName().contains("007"))
				System.out.println("Leave approved by Project Manager!!");
			else
				System.out.println("Leave not approved not approved by Project Manager!!");
		}
		else if(leaveDays>5)
			this.setNextHandler(new HR());
		if(this.nextHandler != null)
			this.nextHandler.handleRequest(request);
	}
}
