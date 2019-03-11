package engine.core;

import engine.character.IEntity;
import engine.event.meta.EventCoordinator;
import engine.event.meta.ButtonInterfacer;
import engine.event.meta.MouseInterfacer;

public class Game {

	private PhysicsEngine pe;
	private GraphicsEngine ge;
	private EventCoordinator ec;
	private ButtonInterfacer ki;
	private MouseInterfacer mi;

	private double width = 800, height = 800;
	private double diagLen = Math.sqrt(width*width + height*height);

	public Game() {

		ec = new EventCoordinator();
		pe = new PhysicsEngine(ec, 60);
		ge = new GraphicsEngine("THE game", 800, 800, 60, diagLen/1000);

		ki = new ButtonInterfacer(ec);
		mi = new MouseInterfacer(ec, 1000/diagLen);

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
