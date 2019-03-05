package game.character;

import java.awt.image.BufferedImage;

public interface Character {

	public void setPos(double[] pos);

	public void setSprite(Sprite sprite);

	public void setHitbox(Hitbox hb);

	public double[] getPos();

	public Sprite getSprite();

	public BufferedImage getImage();

	public Hitbox getHitbox();

}
