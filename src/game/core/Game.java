package game.core;

import game.character.IEntity;
import game.event.meta.EventCoordinator;
import game.event.meta.KeyboardInterfacer;
import game.event.meta.MouseInterfacer;

public class Game {

	private GraphicsEngine ge;
	private PhysicsEngine pe;
	private EventCoordinator ec;
	private KeyboardInterfacer ki;
	private MouseInterfacer mi;

	private double width = 800, height = 800;
	private double diagLen = Math.sqrt(width*width + height*height);

	public Game() {

		ge = new GraphicsEngine("THE game", 800, 800, 60, diagLen);
		pe = new PhysicsEngine(60);
		ec = new EventCoordinator();
		
		ki = new KeyboardInterfacer(ec);
		mi = new MouseInterfacer(ec, diagLen);

	}

	public void start() {
		new Thread(pe).start();
		new Thread(ge).start();

		ge.getFrame().addKeyListener(ki);
		ge.getFrame().addMouseListener(ki);
		ge.getFrame().addMouseWheelListener(mi);
		ge.getFrame().addMouseMotionListener(mi);
	}

	public void addEntity(IEntity ent) {
		ge.addEntity(ent);
		pe.addEntity(ent);
	}

	public void removeEntity(IEntity ent) {
		ge.removeEntity(ent);
		pe.removeEntity(ent);
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
