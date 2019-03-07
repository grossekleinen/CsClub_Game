package game.character;

import java.awt.Image;

import game.math.Vector;

public class Character implements ICharacter {

	private double[] pos;
	private double[] vel;
	private ISprite sprite;
	private Hitbox hitbox;
	
	public Character(double[] pos, double[] vel, ISprite sprite, Hitbox hitbox) {
		this.pos = pos;
		this.vel = vel;
		this.sprite = sprite;
		this.hitbox = hitbox;
	}
	
	public Character(double[] pos, ISprite sprite, Hitbox hitbox) {
		this(pos, new double[2], sprite, hitbox);
	}

	@Override
	public void setPos(double[] pos) {
		this.pos[0] = pos[0];
		this.pos[1] = pos[1];
	}

	@Override
	public void addPos(double[] change) {
		Vector.add(pos, change, pos);
	}

	@Override
	public void subPos(double[] change) {
		Vector.subtract(pos, change, pos);
	}

	@Override
	public void setVel(double[] vel) {
		this.vel[0] = vel[0];
		this.vel[1] = vel[1];
	}

	@Override
	public void addVel(double[] change) {
		Vector.add(vel, change, vel);
	}

	@Override
	public void subVel(double[] change) {
		Vector.subtract(vel, change, vel);
	}

	@Override
	public void setSprite(ISprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public void setHitbox(Hitbox hb) {
		hitbox = hb;
	}

	@Override
	public double[] getPos() {
		return pos;
	}

	@Override
	public double[] getVel() {
		return vel;
	}

	@Override
	public ISprite getSprite() {
		return sprite;
	}

	@Override
	public Image getImage() {
		return sprite.getImage();
	}

	@Override
	public Hitbox getHitbox() {
		return hitbox;
	}

	@Override
	public boolean isTouching(ICharacter other) {
		return hitbox.isTouching(pos, other.getHitbox(), other.getPos());
	}
	
}
