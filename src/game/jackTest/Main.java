package game.jackTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import engine.core.Game;
import engine.entity.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Game g = new Game();
		g.start();
		ISprite sprite = new Sprite(ImageIO.read(new File("src/game/jackTest/sprite.png")), 40, 40);
		List<double[]> boxes = new ArrayList<double[]>();
		boxes.add(new double[] {0, 0, sprite.getWidth(), sprite.getHeight()});
		IHitbox hb = new Hitbox(boxes);
		IEntity ent = new TestEntity(new double[] {0,10}, sprite, hb);
		g.addEntity(ent);
		g.getEventCoordinator().addHandler(new MovementHandler(ent));
	}
}
