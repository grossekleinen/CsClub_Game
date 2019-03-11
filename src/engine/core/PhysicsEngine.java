package engine.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import engine.entity.IEntity;
import engine.event.CollisionEvent;
import engine.event.GameTickEvent;
import engine.event.MovementEvent;
import engine.event.meta.EventCoordinator;
import engine.math.Vector;

public class PhysicsEngine implements Runnable {

	private EventCoordinator ec;
	private List<IEntity> ents;
	private long tpt;//time per tick in millis
	private double tptd;//double version of time per tick in seconds
	private boolean running;

	/**
	 * @param tps ticks per second
	 */
	public PhysicsEngine(EventCoordinator ec, double tps) {
		this.ec = ec;
		tpt = (long) (1000/tps);
		tptd = 1/tps;
		ents = new ArrayList<IEntity>();
	}

	@Override
	public void run() {

		System.out.println("Physics engine starting");

		if (running) {
			System.err.println("ERR: Physics engine attempted to be started while already running");
			Thread.dumpStack();
			return;
		}

		running = true;

		HashMap<IEntity,IEntity> checked = new HashMap<IEntity, IEntity>();
		List<CollisionEvent> collisions = new ArrayList<CollisionEvent>();
		long ticknum = 0;

		while (running) {

			for (IEntity ent : ents) {
				if (ent.getVel()[0] != 0 || ent.getVel()[1] != 0) {
					double[] oldpos = ent.getPos();
					ent.addPos(Vector.scale(ent.getVel(), tptd));
					double[] newpos = ent.getPos();
					ec.fire(new MovementEvent(ent, oldpos, newpos, ticknum));
				}
			}

			for (IEntity ent : ents) {
				ent.clearTouching();
				for (IEntity other : ents) {

					if (ent == other) {
						continue;
					}

					if (checked.get(ent) != other && ent.getIHitbox().isTouching(ent.getPos(), other.getIHitbox(), other.getPos())) {
						collisions.add(new CollisionEvent(new IEntity[] {ent, other}, ticknum));
						ent.addTouching(other);
					}
					checked.put(other, ent);
				}
			}

			for (CollisionEvent c : collisions) {
				ec.fire(c);
			}

			ec.fire(new GameTickEvent(ticknum++));

			try {
				Thread.sleep(tpt);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			checked.clear();
			collisions.clear();

		}

	}

	public void stop() {
		running = false;
	}

	public void setTPS(double tps) {
		tpt = (long) (1000/tps);
		tptd = 1/tps;
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
