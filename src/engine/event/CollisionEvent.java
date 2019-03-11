package engine.event;

import engine.entity.IEntity;
import engine.event.meta.IGameEvent;

public class CollisionEvent implements IGameEvent{

	private IEntity[] parties;
	private long ticknum;

	public CollisionEvent(IEntity[] parties, long ticknum) {
		this.parties = parties;
		this.ticknum = ticknum;
	}

	public IEntity[] getParties() {
		return parties.clone();
	}

	/*
	public void setParties(ICharacter[] parties) {
		this.parties = parties.clone();
	}*/

	@Override
	public long getTickNum() {
		return ticknum;
	}

	@Override
	public String getName() {
		return "COLLISION";
	}
}
