package de.thcproductions.nsuluofuo.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.graphics.Text;
import de.thcproductions.nsuluofuo.main.Handler;





public class Dialog {
	
	public static String text;
	public static String name;
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
		g.fillRoundRect(20, 340, 600, 120, 20, 20);
		Text.drawString(g, Dialog.name, 320, 355, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text, 320, 400, true, Color.BLACK, Assets.text);
	}

	public static boolean isActive() {
		return active;
	}

	public static void setActive(boolean active) {
		Dialog.active = active;
	}
	
	
	

}
