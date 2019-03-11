package engine.event;

import engine.entity.IEntity;
import engine.event.meta.IGameEvent;

public class CollisionEvent implements IGameEvent{

	private IEntity[] parties;
	private long ticknum;

	/**
	 * construct a collision event
	 * @param parties array of two entities involved in the collsion
	 * @param ticknum tick number when this event happened
	 */
	public CollisionEvent(IEntity[] parties, long ticknum) {
		this.parties = parties;
		this.ticknum = ticknum;
	}

	/**
	 * get the entities involved in the collision
	 * @return array of two entities involved in the collision
	 */
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
