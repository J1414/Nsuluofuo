package de.thcproductions.nsuluofuo.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.inventory.Dialog;
import de.thcproductions.nsuluofuo.main.Handler;

public class Malenica extends NPC{
	
	private BufferedImage currentPosition = Assets.iMDown;
	private static String name;
	private String text;
	private String text2;
	private String text3;
	private String text4;
	private String text5;
	private String text6;
	private String text7;
	private Rectangle sbounds;

	public Malenica(Handler handler, float x, float y, String text, String text2, String text3, String text4, String text5, String text6, String text7) {
		super(handler, x, y, name, text, text2, text3, text4, text5, text6, text7);
		sbounds = new Rectangle((int) getX() - 5, (int) getY() - 5, getWidth() + 10, getHeight() + 10);
		this.name = "Ivo Malenica";
		this.text = text;
		this.text2 = text2;
		this.text3 = text3;
		this.text4 = text4;
		this.text5 = text5;
		this.text6 = text6;
		this.text7 = text7;
		
	}
	
	public void update() {
		if (getHealth() < 100000) {
			setHealth(100000);
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE)
				&& handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(sbounds)) {
			Dialog.setActive(!(Dialog.isActive()));
			Dialog.text = text;
			Dialog.name = name;
			Dialog.text2 = text2;
			Dialog.text3 = text3;
			Dialog.text4 = text4;
			Dialog.text5 = text5;
			Dialog.text6 = text6;
			Dialog.text7 = text7;
			if (handler.getWorld().getEntityManager().getPlayer().getCurrentPosition() == handler.getWorld()
					.getEntityManager().getPlayer().getAnimDown().getCurrentFrame()) {
				currentPosition = Assets.iMUp;
			} else if (handler.getWorld().getEntityManager().getPlayer().getCurrentPosition() == handler.getWorld()
					.getEntityManager().getPlayer().getAnimUp().getCurrentFrame()) {
				currentPosition = Assets.iMDown;
			} else if (handler.getWorld().getEntityManager().getPlayer().getCurrentPosition() == handler.getWorld()
					.getEntityManager().getPlayer().getAnimLeft().getCurrentFrame()) {
				currentPosition = Assets.iMRight;
			} else if (handler.getWorld().getEntityManager().getPlayer().getCurrentPosition() == handler.getWorld()
					.getEntityManager().getPlayer().getAnimRight().getCurrentFrame()) {
				currentPosition = Assets.iMLeft;
			}
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(currentPosition, (int) (getX() - handler.getGameCamera().getxOffset()),
				(int) (getY() - handler.getGameCamera().getyOffset()), getWidth(), getHeight(), null);
	}

}
