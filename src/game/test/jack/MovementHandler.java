package game.test.jack;

import engine.entity.IEntity;
import engine.event.*;
import engine.event.ButtonInputEvent.Input;
import engine.event.meta.*;
import engine.math.Vector;

public class MovementHandler implements IEventHandler {

	private IEntity ent;
	private boolean grap = false;
	private double[] newPos;

	public MovementHandler(IEntity e) {
		ent = e;
		newPos = new double[2];
	}

	@ListenTo(events={ButtonInputEvent.class,GameTickEvent.class})
	@Override
	public void handle(IEvent e) {
		if (e instanceof ButtonInputEvent) {
			ButtonInputEvent button = (ButtonInputEvent) e;

			if (button.getInput() == Input.K_RIGHT) {
				if (button.isPressEvent()) {
					ent.addVel(new double[] {100,0});
				}
				if (button.isReleaseEvent()) {
					ent.addVel(new double[] {-100,0});
				}
			}
			if (button.getInput() == Input.K_LEFT) {
				if (button.isPressEvent()) {
					ent.addVel(new double[] {-100,0});
				}
				if (button.isReleaseEvent()) {
					ent.addVel(new double[] {100,0});
				}
			}
			if (button.getInput() == Input.K_UP) {
				if (button.isPressEvent()) {
					ent.addVel(new double[] {0,-250});
				}
			}
			if (button.getInput() == Input.K_SPACE) {
				if (button.isPressEvent()) {
					grap = false;
					ent.setVel(new double[] {0,0});
				}
			}
			if (button.getInput() == Input.M_1) {
				if (button.isPressEvent()) {;
					Vector.subtract(Main.getInstance().getMouseLocation(), ent.getPos(), newPos);
					ent.setVel(newPos);
					grap = true;
				}
			}
		}
		if (e instanceof GameTickEvent) {
			if (ent.getPos()[1] < 500) {
				ent.addVel(new double[] {0,10});
			}
			if (ent.getPos()[1] >= 500) {
				double vel = ent.getVel()[1];
				vel = (0 - vel);
				ent.addVel(new double[] {0,vel});
			}
			if (grap) {
				if (Vector.equals(ent.getPos(), Main.getInstance().getMouseLocation())) {
					System.out.println("grappled");
				}
				Vector.subtract(Main.getInstance().getMouseLocation(), ent.getPos(), newPos);
				ent.setVel(newPos);
			}
		}
	}
	
}
