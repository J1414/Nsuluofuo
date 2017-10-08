package de.thcproductions.nsuluofuo.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.graphics.Text;
import de.thcproductions.nsuluofuo.main.Handler;





public class Dialog {
	
	public static String text;
	public static String text2;
	public static String text3;
	public static String text4;
	public static String text5;
	public static String text6;
	public static String text7;
	public static String name;
	public static BufferedImage portrait;
	private static boolean active;
	private Handler handler;

	public Dialog(Handler handler) {
		super();
		
	}
	
	public void update() {
		if(!active) {
			return;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE)) {
			active = ! active;
		}
	}
	
	public static void render(Graphics g) {
		if(!active) {
			return;
		}
		g.setColor(new Color(255,255,255,200));
		g.fillRoundRect(20, 300, 600, 160, 20, 20);
		Text.drawString(g, Dialog.name, 90, 445, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text, 395, 320, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text2, 395, 340, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text3, 395, 360, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text4, 395, 380, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text5, 395, 400, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text6, 395, 420, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text7, 395, 440, true, Color.BLACK, Assets.smallText);
		
		g.drawImage(portrait, 30, 310, null);
	}

	public static boolean isActive() {
		return active;
	}

	public static void setActive(boolean active) {
		Dialog.active = active;
	}
	
	
	

}
