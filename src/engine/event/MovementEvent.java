package engine.event;

import engine.entity.IEntity;
import engine.event.meta.IGameEvent;

public class MovementEvent implements IGameEvent{

	private IEntity mover;
	private long ticknum;

	public MovementEvent(IEntity mover, double[] oldpos, double[] newpos, long ticknum) {
		this.mover = mover;
		this.ticknum = ticknum;
	}

	public IEntity getMover() {
		return mover;
	}

	@Override
	public long getTickNum() {
		return ticknum;
	}

	@Override
	public String getName() {
		return "MOVEMENT";
	}
}
