package game.event;

import game.event.meta.IEvent;

public class PlayerInputEvent implements IEvent {

	public PlayerInputEvent(InputType type) {
		
	}
	
	public enum InputType {
		MOUSE,
		KEY_PRESS,
		KEY_RELEASE;
	}
	
	@Override
	public String getName() {
		return "PLAYER_INPUT";
	}
	
	
	
}
