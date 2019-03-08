package engine.character;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import engine.math.Vector;

public class Entity implements IEntity {

	private double[] pos;
	private double[] vel;
	private ISprite sprite;
	private IHitbox hb;
	private List<IEntity> touching;

	public Entity(double[] pos, double[] vel, ISprite sprite, IHitbox hb) {
		this.pos = pos;
		this.vel = vel;
		this.sprite = sprite;
		this.hb = hb;
		this.touching = new ArrayList<IEntity>();
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
		return sprite.getInstance();
	}

	@Override
	public IHitbox getIHitbox() {
		return hb;
	}

	@Override
	public boolean isTouching(IEntity other) {
		return touching.contains(other);
	}

	@Override
	public void addTouching(IEntity ent) {
		touching.add(ent);
	}

	@Override
	public void removeTouching(IEntity ent) {
		touching.remove(ent);
	}

	@Override
	public List<IEntity> getTouching(){
		return touching;
	}

	@Override
	public void setTouching(List<IEntity> touching) {
		this.touching = touching;
	}

	@Override
	public void clearTouching() {
		touching.clear();
	}

}
