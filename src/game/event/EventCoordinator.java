package game.event;

import java.util.ArrayList;
import java.util.List;

public class EventCoordinator {
	
	private List<IEventHandler> handlers;
	
	public EventCoordinator() {
		handlers = new ArrayList<IEventHandler>();
	}
	
	public void fire(IEvent e) {
		for (IEventHandler h : handlers) {
			if (e.getClass().isAssignableFrom(h.getHandleType()) || h.getHandleType() == null) {
				h.handle(e);
			}
		}
	}
	
	public boolean addHandler(IEventHandler h) {
		return handlers.add(h);
	}
	
	public boolean removeHandler(IEventHandler h) {
		return handlers.remove(h);
	}
	
}
