package mediatorPattern;

public class Client {
	public static void main(String []args)
	{
		IChatMediator admin = new ChatMediator();
		admin.addUser(new BasicUser(admin,"Basic User 1"));
		admin.addUser(new BasicUser(admin,"Basic User 2"));
		admin.addUser(new BasicUser(admin,"Basic User 3"));
		admin.addUser(new PremiumUser(admin,"Premium User 1"));
		admin.addUser(new PremiumUser(admin,"Premium User 2"));
		IUser source = new PremiumUser(admin,"Premium source 1");
		admin.sendMessage("Hello everyone. Welcome to Chat-R-Us!!");
	}
}
