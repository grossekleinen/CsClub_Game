package game.event;

import game.character.ICharacter;
import game.event.meta.IEvent;

public class CollisionEvent implements IEvent{

	private ICharacter[] parties;

	public CollisionEvent(ICharacter[] parties) {
		this.parties = parties;
	}

	public ICharacter[] getParties() {
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
