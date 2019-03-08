package engine.character;

import java.awt.Image;
import java.awt.image.BufferedImage;

public interface ISprite {

	public void setImage(BufferedImage i, int width, int height);

	public void setSize(int width, int height);

	public void setStaticImage(BufferedImage i);
	
	public Image getInstance();

	public BufferedImage getStaticImage();

	public int getWidth();

	public int getHeight();

}
