package engine.event.meta;

public interface IGameEvent extends IEvent {

	/**
	 * get the game tick number when the event happened
	 * @return the game tick number when the event happened
	 */
	public long getTickNum();

}
