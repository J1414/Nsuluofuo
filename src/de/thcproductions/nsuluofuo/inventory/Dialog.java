package de.thcproductions.nsuluofuo.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

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
		Text.drawString(g, Dialog.name, 20, 300, false, Color.GREEN, Assets.smallText);
		Text.drawString(g, Dialog.text, 320, 320, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text2, 320, 340, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text3, 320, 360, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text4, 320, 380, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text5, 320, 400, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text6, 320, 420, true, Color.BLACK, Assets.smallText);
		Text.drawString(g, Dialog.text7, 320, 440, true, Color.BLACK, Assets.smallText);
	}

	public static boolean isActive() {
		return active;
	}

	public static void setActive(boolean active) {
		Dialog.active = active;
	}
	
	
	

}
