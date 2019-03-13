package game.jackTest;

import java.io.IOException;

import engine.entity.IEntity;
import engine.event.*;
import engine.event.ButtonInputEvent.Input;
import engine.event.meta.*;

public class MovementHandler implements IEventHandler {

	private IEntity ent;
	private int grap = 0;
	private double newX;
	private double newY;
	private double mouseX;
	private double mouseY;

	public MovementHandler(IEntity e) {
		ent = e;
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
					grap = 0;
					ent.setVel(new double[] {0,0});
				}
			}
			if (button.getInput() == Input.M_1) {
				if (button.isPressEvent()) {
					mouseX = MouseInterfacer.getMouseLocation()[0];
					mouseY = MouseInterfacer.getMouseLocation()[1];
					newY = MouseInterfacer.getMouseLocation()[1] - ent.getPos()[1];
					newX = MouseInterfacer.getMouseLocation()[0] - ent.getPos()[0];
					ent.setVel(new double[] {newX,newY});
					grap = 1;
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
			if (grap == 1) {
				if (ent.getPos()[0] == mouseX) {
					if (ent.getPos()[1] == mouseY) {
						System.out.println("grappled");
					}
				}
				newY = mouseY - ent.getPos()[1];
				newX = mouseX - ent.getPos()[0];
				ent.setVel(new double[] {newX,newY});
			}
		}
	}
	
}
