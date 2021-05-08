package mediatorPattern;
import java.util.List;
import java.util.ArrayList;
public class ChatMediator implements IChatMediator{
	private List<IUser> users;
	public ChatMediator()
	{
		this.users = new ArrayList<>();
	}
	public void addUser(IUser user)
	{
		users.add(user);
	}
	public void sendMessage(String message)
	{
		for (IUser user : users)
		{
			user.receiveMessage(message);
		}
	}
}
