package mediatorPattern;

public class PremiumUser implements IUser{
	private IChatMediator chatMediator;
	private String name;
	public PremiumUser(IChatMediator chatMediator,String name)
	{
		this.chatMediator = chatMediator;
		this.name = name;
	}
	public void receiveMessage(String message)
	{
		System.out.println(this.name+" : "+message);
	}
	public void sendMessage(String message)
	{
		this.chatMediator.sendMessage(message);
	}
}
