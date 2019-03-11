package engine.entity;

import java.awt.Image;
import java.util.List;

public interface IEntity {

	/**
	 * sets the position of this entity
	 * @param pos new position of this entity
	 */
	public void setPos(double[] pos);

	/**
	 * adds a 2D vector to the position of this entity
	 * @param change position vector to be added to the current position
	 */
	public void addPos(double[] change);

	/**
	 * subtracts a 2D vector from the position of this entity
	 * @param change position vector to be subtracted from the current position
	 */
	public void subPos(double[] change);

	/**
	 * sets the velocity of this entity
	 * @param pos new velocity of this entity
	 */
	public void setVel(double[] vel);

	/**
	 * adds a 2D vector to the velocity of this entity
	 * @param change velocity vector to be added to the current velocity
	 */
	public void addVel(double[] change);

	/**
	 * subtracts a 2D vector from the position of this entity
	 * @param pos position vector to be subtracted from the current position
	 */
	public void subVel(double[] change);

	/**
	 * sets the sprite of this entity
	 * @param sprite new sprite of this entity
	 */
	public void setSprite(ISprite sprite);

	/**
	 * sets the hitbox of this entity
	 * @param hb new hitbox of this entity
	 */
	public void setIHitbox(IHitbox hb);

	/**
	 * gets the position of this entity
	 * @return the current position of this entity
	 */
	public double[] getPos();

	/**
	 * gets the velocity of this entity
	 * @return the current velocity of this entity
	 */
	public double[] getVel();

	/**
	 * gets the sprite of this entity
	 * @return the sprite of this entity
	 */
	public ISprite getSprite();

	/**
	 * gets the current image of this entity
	 * @return the current image from the sprite of this entity
	 */
	public Image getImage();

	/**
	 * gets the hitbox of this entity
	 * @return the hitbox of this entity
	 */
	public IHitbox getIHitbox();

	/**
	 * gets whether this entity is touching another
	 * @param other the other entity to check if this entity is touching
	 * @return true if touching false if other is this or not touching
	 */
	public boolean isTouching(IEntity other);

	/**
	 * this function should only be used by in-engine activities!
	 * adds an entity which this entity is touching
	 * @param ent entity to be added to those which this entity is touching
	 */
	public void addTouching(IEntity ent);

	/**
	 * this function should only be used by in-engine activities!
	 * removes an entity from those which this entity is touching
	 * @param ent entity to be removed from those which this entity is touching
	 */
	public void removeTouching(IEntity ent);

	/**
	 * gets the list of entities this entity is touching
	 * @return the list of entities this entity is touching
	 */
	public List<IEntity> getTouching();

	/**
	 * this function should only be used by in-engine activities!
	 * sets the entities this entity is touching
	 * @param touching new list of entities this entity is touching
	 */
	public void setTouching(List<IEntity> touching);

	/**
	 * this function should only be used by in-engine activities!
	 * clears the list of entities this entity is touching
	 */
	public void clearTouching();

}
