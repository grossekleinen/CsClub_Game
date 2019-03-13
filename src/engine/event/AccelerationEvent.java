package engine.event;

import engine.entity.IEntity;
import engine.event.meta.IGameEvent;

public class AccelerationEvent implements IGameEvent {

	private IEntity ent;
	private double[] oldvel, newvel;
	private long ticknum;

	public AccelerationEvent(IEntity ent, double[] oldvel, double[] newvel, long ticknum) {
		this.ent = ent;
		this.oldvel = oldvel;
		this.newvel = newvel;
		this.ticknum = ticknum;
	}

	/**
	 * get the entity which is the object of this event
	 * @return the entity which is the object of this event
	 */
	public IEntity getEntity() {
		return ent;
	}

	/**
	 * get the old velocity of the entity
	 * @return the old velocity of the entity
	 */
	public double[] getOldVel() {
		return oldvel.clone();
	}

	/**
	 * get the new velocity of the entity
	 * @return the new velocity of the entity
	 */
	public double[] getNewVel() {
		return newvel.clone();
	}

	@Override
	public long getTickNum() {
		return ticknum;
	}

	@Override
	public String getName() {
		return "ACCELERATION";
	}

}
