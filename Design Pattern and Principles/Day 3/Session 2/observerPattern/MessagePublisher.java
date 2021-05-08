package observerPattern;
import java.util.ArrayList;
import java.util.List;
public class MessagePublisher implements Subject{
	private List<Observer> observers = new ArrayList<>();
	private Message state;
	@Override
	public void attach(Observer o) {
		observers.add(o);
	}
	@Override
	public void detach(Observer o) { 
		observers.remove(o); 
	} 
	@Override 
	public void notifyUpdate(Message m) { 
		for(Observer o: observers) 
		{ 
			o.update(m); 
		}
	}
	public Message getState()
	{
		return this.state;
	}
	public void setState(Message state)
	{
		this.state = state;
		notifyUpdate(state);
	}
}
