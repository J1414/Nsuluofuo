package de.thcproductions.nsuluofuo.creatures;

import de.thcproductions.nsuluofuo.entities.Entity;
import de.thcproductions.nsuluofuo.graphics.tiles.Tile;
import de.thcproductions.nsuluofuo.main.Handler;

public abstract class Creature extends Entity {

	public static final float DEFAULT_SPEED = 1.5f;
	public static final int DEFAULT_CREATURE_WIDTH = 32, DEFAULT_CREATURE_HEIGHT = 32;

	private float speed;
	private float xMove, yMove = 0;

	public float getxMove() {
		return xMove;
	}

	public void moveX() {
		if (xMove > 0) {
			int tx = (int) (getX() - xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

			if (!collisionWithTile(tx, (int) (getY() + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				setX(getX() + getxMove());
			}
		} else if (xMove < 0) {
			int tx = (int) (getX() + xMove + bounds.x) / Tile.TILEWIDTH;

			if (!collisionWithTile(tx, (int) (getY() + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (getY() + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				setX(getX() + getxMove());
			}
		}
	}

	public void moveY() {
		if (yMove < 0) {
			int ty = (int) (getY() + yMove + bounds.y) / Tile.TILEHEIGHT;

			if (!collisionWithTile((int) (getX() + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				setY(getY() + getyMove());
			}
		} else if (yMove > 0) {
			int ty = (int) (getY() + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

			if (!collisionWithTile((int) (getX() + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (getX() + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				setY(getY() + getyMove());
			}

		}
	}

	private boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		setSpeed(DEFAULT_SPEED);
	}

	public void move() {
		if (!checkEntityCollisions(getxMove(), 0f))
			moveX();
		if (!checkEntityCollisions(0f, getyMove()))
			moveY();
	}

	public void giveExp(int amount) {
		for (int i = 0; i < amount; i++) {
			handler.getWorld().getEntityManager().getPlayer()
					.setExp(handler.getWorld().getEntityManager().getPlayer().getExp() + 1);
			if (handler.getWorld().getEntityManager().getPlayer().getExp() >= handler.getWorld().getEntityManager()
					.getPlayer().getMaxExp()) {
				handler.getWorld().getEntityManager().getPlayer().setExp(0);
				handler.getWorld().getEntityManager().getPlayer()
						.setLevel(handler.getWorld().getEntityManager().getPlayer().getLevel() + 1);
				handler.getWorld().getEntityManager().getPlayer()
						.setMaxExp(handler.getWorld().getEntityManager().getPlayer().getMaxExp()
								+ (handler.getWorld().getEntityManager().getPlayer().getMaxExp() / 2));
				
			}
		}
	}

	public void path() {
		setxMove(0.0f);
		setyMove(0.0f);

		int width = 0;
		if (getWidth() > handler.getWorld().getEntityManager().getPlayer().getWidth()) {
			width = 32;
		}

		if (getX() + width < handler.getWorld().getEntityManager().getPlayer().getX()) {
			setxMove(getxMove() + getSpeed());
		} else if (getX() + width > handler.getWorld().getEntityManager().getPlayer().getX()) {
			setxMove(getxMove() - getSpeed());
		} else if (getY() + width < handler.getWorld().getEntityManager().getPlayer().getY()) {
			setyMove(getyMove() + getSpeed());
		} else if (getY() + width > handler.getWorld().getEntityManager().getPlayer().getY()) {
			setyMove(getY() - getSpeed());
		}

	}

}
