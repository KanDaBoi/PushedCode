package corPattern;

public abstract class ILeaveRequestHandler {
	protected ILeaveRequestHandler nextHandler;
	public abstract void handleRequest(LeaveRequest request);
}
