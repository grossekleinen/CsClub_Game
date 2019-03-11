package engine.event;

import engine.event.meta.IEvent;

public class MouseInputEvent implements IEvent {

	private final double[] loc;

	/**
	 * constructs a MouseInputEvent
	 * @param loc the location of the mouse cursor at this event in in-game coordinates
	 */
	public MouseInputEvent(double[] loc) {
		this.loc = loc;
	}

	/**
	 * get the location of the pointer at this event in-game coordinates
	 * @return the location of the mouse cursor at this event
	 */
	public double[] getLocation() {
		return loc.clone();
	}

	@Override
	public String getName() {
		return "MOUSE_INPUT";
	}

}
