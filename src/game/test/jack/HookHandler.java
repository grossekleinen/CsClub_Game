package game.test.jack;

import engine.entity.IEntity;
import engine.event.*;
import engine.event.ButtonInputEvent.Input;
import engine.event.meta.*;
import engine.math.Vector;

public class HookHandler implements IEventHandler {

	private IEntity ent;
	private double[] mousePos = new double[] {0,0};

	public HookHandler(IEntity e) {
		ent = e;
	}

	@ListenTo(events={ButtonInputEvent.class,GameTickEvent.class,MouseInputEvent.class})
	@Override
	public void handle(IEvent e) {
		if (e instanceof ButtonInputEvent) {
			ButtonInputEvent button = (ButtonInputEvent) e;
			if (button.getInput() == Input.M_1) {
				if (button.isPressEvent()) {
					mousePos = Main.getInstance().getMouseLocation();
					ent.setPos(mousePos);
				}
			}
			ent.setPos(mousePos);
		}
		if (e instanceof GameTickEvent) {
			try {
				mousePos = Main.getInstance().getMouseLocation();
			} catch (Exception NullPointerException) {
			}
			finally {
			}
			ent.setPos(mousePos);
		}
	}
}
