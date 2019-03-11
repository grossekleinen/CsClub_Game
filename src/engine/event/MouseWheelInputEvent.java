package engine.event;

import engine.event.meta.IEvent;

public class MouseWheelInputEvent implements IEvent {

	private final int rotations;

	public MouseWheelInputEvent(int rotations) {
		this.rotations = rotations;
	}

	public int getRotations() {
		return rotations;
	}

	@Override
	public String getName() {
		return "MOUSE_WHEEL_INPUT_EVENT";
	}

}
