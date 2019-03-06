package game.event;

public interface IEventHandler {

	public void handle(IEvent e);
	
	public Class<?> getHandleType();//null means handling all events

}
