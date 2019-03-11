package engine.entity;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Sprite implements ISprite {

	private BufferedImage staticImage;
	private Image instance;
	private int width, height;

	public Sprite(BufferedImage i, int width, int height) {
		setImage(i, width, height);
	}

	@Override
	public Image getInstance() {
		return instance;
	}

	@Override
	public void setImage(BufferedImage i, int width, int height) {
		staticImage = i;

		instance = new BufferedImage(width, height, i.getType());
		Graphics2D g = (Graphics2D) instance.getGraphics();
		g.scale(width/(double) i.getWidth(), height/(double) i.getHeight());
		g.drawImage(i, 0, 0, null);
		g.dispose();

		this.width = width;
		this.height = height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setSize(int width, int height) {
		setImage(staticImage, width, height);
	}

	@Override
	public void setStaticImage(BufferedImage i) {
		setImage(i, width, height);
	}

	@Override
	public BufferedImage getStaticImage() {
		return staticImage;
	}
}
