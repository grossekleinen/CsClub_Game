package game.event;

import game.character.IEntity;
import game.event.meta.IEvent;

public class CollisionEvent implements IEvent{

	private IEntity[] parties;

	public CollisionEvent(IEntity[] parties) {
		this.parties = parties;
	}

	public IEntity[] getParties() {
		return parties.clone();
	}

	/*
	public void setParties(ICharacter[] parties) {
		this.parties = parties.clone();
	}*/

	@Override
	public String getName() {
		return "COLLISION";
	}
}
