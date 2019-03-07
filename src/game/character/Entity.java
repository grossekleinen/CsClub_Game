package game.character;

import java.awt.Image;

import game.math.Vector;

public class Entity implements IEntity {

	private double[] pos;
	private double[] vel;
	private ISprite sprite;
	private IHitbox hb;
	
	public Entity(double[] pos, double[] vel, ISprite sprite, IHitbox hb) {
		this.pos = pos;
		this.vel = vel;
		this.sprite = sprite;
		this.hb = hb;
	}
	
	public Entity(double[] pos, ISprite sprite, IHitbox hb) {
		this(pos, new double[2], sprite, hb);
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
	public void setIHitbox(IHitbox hb) {
		this.hb = hb;
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
	public IHitbox getIHitbox() {
		return hb;
	}

	@Override
	public boolean isTouching(IEntity other) {
		return hb.isTouching(pos, other.getIHitbox(), other.getPos());
	}
	
}
