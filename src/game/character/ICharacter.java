package game.character;

import java.awt.Image;

public interface ICharacter {

	public void setPos(double[] pos);

	public void addPos(double[] change);

	public void subPos(double[] change);

	public void setVel(double[] vel);

	public void addVel(double[] change);

	public void subVel(double[] change);

	public void setSprite(ISprite sprite);

	public void setHitbox(Hitbox hb);

	public double[] getPos();

	public double[] getVel();

	public ISprite getSprite();

	public Image getImage();

	public Hitbox getHitbox();
	
	public boolean isTouching(ICharacter other);

}
