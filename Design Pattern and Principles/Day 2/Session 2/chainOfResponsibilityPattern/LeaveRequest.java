package corPattern;

public class LeaveRequest {
	private String employeeName;
	private int leaveDays;
	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}
	public String getEmployeeName()
	{
		return this.employeeName;
	}
	public void setLeaveDays(int leaveDays)
	{
		this.leaveDays = leaveDays;
	}
	public int getLeaveDays()
	{
		return this.leaveDays;
	}
	public LeaveRequest(String employeeName,int leaveDays)
	{
		this.employeeName = employeeName;
		this.leaveDays = leaveDays;
	}
}
