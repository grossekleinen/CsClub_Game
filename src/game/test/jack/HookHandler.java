package game.test.jack;

import engine.entity.IEntity;
import engine.event.*;
import engine.event.ButtonInputEvent.Input;
import engine.event.meta.*;
import engine.math.Vector;

public class HookHandler implements IEventHandler {

	private IEntity ent;
	private double[] mousePos;

	public HookHandler(IEntity e) {
		ent = e;
	}

	@ListenTo(events={ButtonInputEvent.class,GameTickEvent.class})
	@Override
	public void handle(IEvent e) {
		if (e instanceof GameTickEvent) {
			mousePos = Main.getInstance().getMouseLocation();
			ent.setPos(mousePos);
		}
	}
}
