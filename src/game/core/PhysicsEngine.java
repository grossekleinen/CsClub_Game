package game.core;

import java.util.List;

import game.character.IEntity;

public class PhysicsEngine implements Runnable {

	private List<IEntity> ents;
	private long tpt;//time per tick
	private boolean running;

	/**
	 * @param tps ticks per second
	 */
	public PhysicsEngine(double tps) {
		tpt = (long) (1000/tps);
	}

	@Override
	public void run() {

		System.out.println("Physics engine starting");

		while (running) {

			for (IEntity ent : ents) {

			}

			try {
				Thread.sleep(tpt);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void stop() {
		running = false;
	}

	public void setTPS(double tps) {
		tpt = (long) (1000/tps);
	}

	public boolean addEntity(IEntity ent) {
		return ents.add(ent);
	}

	public boolean removeEntity(IEntity ent) {
		return ents.remove(ent);
	}

	public boolean hasEntity(IEntity ent) {
		return ents.contains(ent);
	}

}
