package engine.event;

import engine.event.meta.IGameEvent;

public class GameTickEvent implements IGameEvent {

	private long ticknum;

	public GameTickEvent(long ticknum) {
		this.ticknum = ticknum;
	}

	@Override
	public long getTickNum() {
		return ticknum;
	}

	@Override
	public String getName() {
		return "GAME_TICK";
	}

}
