package game.jack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import engine.core.Game;
import engine.entity.*;

public class HookTest {
	private static Game g;
	
	public static void summonHook() throws IOException {
		g = Main.getInstance();
		ISprite sprite = new Sprite(ImageIO.read(new File("src/game/jack/aimer.png")), 20, 20);
		List<double[]> boxes = new ArrayList<double[]>();
		boxes.add(new double[] {0, 0, sprite.getWidth(), sprite.getHeight()});
		IHitbox hb = new Hitbox(boxes);
		IEntity ent = new TestEntity(new double[] {50,10}, sprite, hb);
		g.addEntity(ent);
		g.getEventCoordinator().addHandler(new HookHandler(ent));
	}
}
