package de.thcproductions.nsuluofuo.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import de.thcproductions.nsuluofuo.main.Handler;

public abstract class Entity {

	public static final int DEFAULT_HEALTH = 10;
	protected Handler handler;
	private float x, y;
	private int health;
	private int maxHealth;
	private int strength;
	private int width, height;
	private boolean active = true;
	protected Rectangle bounds;
	protected Rectangle dbounds;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Entity(Handler handler, float x, float y, int width, int height) {

		this.handler = handler;
		setMaxHealth(DEFAULT_HEALTH);
		setHealth(getMaxHealth());
		this.x = x*32;
		this.y = y*32;
		this.width = width;
		this.height = height;

		bounds = new Rectangle(0, 0, width, height);
		dbounds = new Rectangle((int) (getX() + bounds.x), (int) (getY() + bounds.y), width, height);
	}

	public abstract void update();

	public abstract void render(Graphics g);

	public void hurt(int amount) {
		setHealth(getHealth() - amount);
		if (getHealth() <= 0) {
			setActive(false);
			die();
		}
	}

	public void die() {
		setActive(false);
	}

	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				return true;
			}
		}
		return false;
	}

	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (getX() + bounds.x + xOffset), (int) (getY() + bounds.y + yOffset), bounds.width,
				bounds.width);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	

}
