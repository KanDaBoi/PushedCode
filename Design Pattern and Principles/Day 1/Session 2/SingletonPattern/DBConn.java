package day1Session2;

public class DBConn {
	private static DBConn conn;
	private DBConn()
	{
		
	}
	public static DBConn getInstance()
	{
		if(conn==null)
		{
			synchronized(DBConn.class)
			{
				conn = new DBConn();
			}
		}
		return conn;
	}
}