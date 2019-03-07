package game.event.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventCoordinator {

	private HashMap<Class<? extends IEvent>, List<IEventHandler>> handlers;

	public EventCoordinator() {
		handlers = new HashMap<Class<? extends IEvent>, List<IEventHandler>>();
	}

	/**
	 * fires an event
	 * @param e event to be fired
	 */
	public void fire(IEvent e) {
		
		synchronized(handlers) {

			for (Class<? extends IEvent> ev : handlers.keySet()) {
				if (ev.isAssignableFrom(e.getClass())) {
					for (IEventHandler h : handlers.get(ev)) {
						h.handle(e);
					}
				}
			}

		}
	}

	/**
	 * registers an event handler
	 * @param h the event handler
	 * @throws SecurityException
	 */
	public void addHandler(IEventHandler h) throws SecurityException {

		ListenTo[] annos;
		try {
			annos = h.getClass().getMethod("handle", IEvent.class).getAnnotationsByType(ListenTo.class);
		} catch (NoSuchMethodException e) {
			annos = new ListenTo[0];
			System.err.println("Reflection code in EventCoordinator must be updated for changes made in IEventHandler!");
			e.printStackTrace();
		}

		synchronized(handlers) {
			if (annos.length > 0) {

				for (Class<? extends IEvent> ev : annos[annos.length - 1].events()) {
					if (!handlers.containsKey(ev)) {
						List<IEventHandler> list = new ArrayList<IEventHandler>();
						handlers.put(ev, list);
					}
					handlers.get(ev).add(h);
				}

			} else {

				if (!handlers.containsKey(IEvent.class)) {
					List<IEventHandler> list = new ArrayList<IEventHandler>();
					handlers.put(IEvent.class, list);
				}
				handlers.get(IEvent.class).add(h);

			}
		}

	}

	/**
	 * removes an event handler
	 * @param h event handler to be removed
	 * @throws SecurityException
	 */
	public void removeHandler(IEventHandler h) throws SecurityException {

		ListenTo[] annos;
		try {
			annos = h.getClass().getMethod("handle", IEvent.class).getAnnotationsByType(ListenTo.class);
		} catch(NoSuchMethodException e) {
			annos = new ListenTo[0];
			System.err.println("Reflection code in EventCoordinator must be updated for changes made in IEventHandler!");
			e.printStackTrace();
		}

		synchronized(handlers) {

			if (annos.length > 0) {

				for (Class<? extends IEvent> ev : annos[annos.length - 1].events()) {
					if (handlers.containsKey(ev)) {
						List<IEventHandler> list = handlers.get(ev);
						list.remove(h);
						if (list.size() == 0) {
							handlers.remove(ev);
						}
					}
				}

			} else {
				if (handlers.containsKey(IEvent.class)) {
					List<IEventHandler> list = handlers.get(IEvent.class);
					list.remove(h);
					if (list.size() == 0) {
						handlers.remove(IEvent.class);
					}
				}
			}

		}

	}


}
