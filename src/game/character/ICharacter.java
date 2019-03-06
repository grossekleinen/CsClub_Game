package game.character;

import java.awt.Image;

public interface ICharacter {

	public void setPos(double[] pos);

	public void setSprite(ISprite sprite);

	public void setHitbox(Hitbox hb);

	public double[] getPos();

	public ISprite getSprite();

	public Image getImage();

	public Hitbox getHitbox();

}
