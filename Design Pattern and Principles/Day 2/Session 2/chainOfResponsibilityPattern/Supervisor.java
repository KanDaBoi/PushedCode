package corPattern;

public class Supervisor extends ILeaveRequestHandler{
	protected ILeaveRequestHandler nextHandler;
	private void setNextHandler(ILeaveRequestHandler nextHandler)
	{
		this.nextHandler = nextHandler;
	}
	public void handleRequest(LeaveRequest request)
	{
		int leaveDays = request.getLeaveDays();
		if(leaveDays<1)
			System.out.println("Bogus leave request!!Warning issued for wasting time.");
		else if(leaveDays>=1 && leaveDays<3)
		{
			if(request.getEmployeeName().contains("007"))
				System.out.println("Leave approved by Supervisor!!");
			else
				System.out.println("Leave not approved by Supervisor!!");
		}
		else if(leaveDays>=3)
			this.setNextHandler(new ProjectManager());
		if(this.nextHandler != null)
			this.nextHandler.handleRequest(request);
	}
}
