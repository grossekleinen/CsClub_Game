package game.character;

import java.awt.image.BufferedImage;

public class Sprite implements ISprite {

	private BufferedImage i;
	
	public Sprite(BufferedImage i) {
		this.i=i;
	}
	
	public void setImage(BufferedImage i){
		this.i=i;
	}
	
	@Override
	public BufferedImage getImage() {
		return i;
	}
}
