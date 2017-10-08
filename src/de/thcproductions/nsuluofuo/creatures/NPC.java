package de.thcproductions.nsuluofuo.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.inventory.Dialog;
import de.thcproductions.nsuluofuo.main.Handler;

public class NPC extends Creature {

	private boolean active;
	private String name;
	private String text;
	private float x,y;
	private Rectangle sbounds;
	private BufferedImage currentPosition = Assets.mNpcDown;

	public NPC(Handler handler, float x, float y, String name, String text) {
		super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		this.x = x*32;
		this.y = y*32;
		bounds.x = 8;
		bounds.y = 16;
		bounds.width = 16;
		bounds.height = 16;
		sbounds = new Rectangle((int) getX() - 5, (int) getY() - 5, getWidth() + 10, getHeight() + 10);
		this.name = name;
		this.text = text;
		setHealth(100000);

	}

	@Override
	public void update() {
		if (getHealth() < 100000) {
			setHealth(100000);
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE)
				&& handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(sbounds)) {
			Dialog.setActive(!(Dialog.isActive()));
			Dialog.text = text;
			Dialog.name = name;
			if (handler.getWorld().getEntityManager().getPlayer().getCurrentPosition() == handler.getWorld()
					.getEntityManager().getPlayer().getAnimDown().getCurrentFrame()) {
				currentPosition = Assets.mNpcUp;
			} else if (handler.getWorld().getEntityManager().getPlayer().getCurrentPosition() == handler.getWorld()
					.getEntityManager().getPlayer().getAnimUp().getCurrentFrame()) {
				currentPosition = Assets.mNpcDown;
			} else if (handler.getWorld().getEntityManager().getPlayer().getCurrentPosition() == handler.getWorld()
					.getEntityManager().getPlayer().getAnimLeft().getCurrentFrame()) {
				currentPosition = Assets.mNpcRight;
			} else if (handler.getWorld().getEntityManager().getPlayer().getCurrentPosition() == handler.getWorld()
					.getEntityManager().getPlayer().getAnimRight().getCurrentFrame()) {
				currentPosition = Assets.mNpcLeft;
			}
		}
		

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(currentPosition, (int) (getX() - handler.getGameCamera().getxOffset()),
				(int) (getY() - handler.getGameCamera().getyOffset()), getWidth(), getHeight(), null);
	}
	
	

}
