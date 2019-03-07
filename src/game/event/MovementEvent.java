package game.event;

import game.character.IEntity;
import game.event.meta.IEvent;

public class MovementEvent implements IEvent{

	private IEntity mover;

	public MovementEvent(IEntity mover) {
		this.mover = mover;
	}

	public IEntity getMover() {
		return mover;
	}

	@Override
	public String getName() {
		return "MOVEMENT";
	}
}
