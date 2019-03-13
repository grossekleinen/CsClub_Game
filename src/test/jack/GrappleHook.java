package test.jack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import engine.entity.Hitbox;
import engine.entity.IEntity;
import engine.entity.IHitbox;
import engine.entity.ISprite;
import engine.entity.Sprite;
import engine.core.*;

public class GrappleHook {
	public static void pos() throws IOException {
		Game g = new Game();
		double[] pos = g.getMouseLocation();
		ISprite sprite = new Sprite(ImageIO.read(new File("src/game/jackTest/hook.png")), 10, 10);
		List<double[]> boxes = new ArrayList<double[]>();
		boxes.add(new double[] {0, 0, sprite.getWidth(), sprite.getHeight()});
		IHitbox hb = new Hitbox(boxes);
		IEntity ent = new TestEntity(pos, sprite, hb);
		g.addEntity(ent);
	}
}
