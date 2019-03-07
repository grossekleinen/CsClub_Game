package game.core;

import game.event.meta.EventCoordinator;

public class Game {

	private GraphicsEngine ge;
	private PhysicsEngine pe;
	private EventCoordinator ec;

	public Game() {

		ge = new GraphicsEngine("THE game", 800, 800, 60);
		pe = new PhysicsEngine();
		ec = new EventCoordinator();

	}
	
	public void start() {
		new Thread(pe).run();
		new Thread(ge).run();
	}
	
	public GraphicsEngine getGraphics() {
		return ge;
	}
	
	public PhysicsEngine getPhysics() {
		return pe;
	}
	
	public EventCoordinator getEventCoordinator() {
		return ec;
	}

}
