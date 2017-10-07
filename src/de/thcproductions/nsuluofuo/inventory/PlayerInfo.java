package de.thcproductions.nsuluofuo.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.graphics.Text;
import de.thcproductions.nsuluofuo.main.Handler;

public class PlayerInfo {

	private Handler handler;
	private boolean active = false;
	private boolean itemScreen;
	private boolean trivel;
	private Color color;
	private Date currentDate = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	private String formattedDate = sdf.format(currentDate);

	public PlayerInfo(Handler handler) {
		this.handler = handler;
		color = new Color(255, 255, 255, 200);
	}

	public void update() {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
			active = !active;
			
		}

		if (!active) {
			return;
		}
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT)){
			active = !active;
			handler.getWorld().getEntityManager().getPlayer().getInventory().setActive(true);
		}
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT)){
			active = !active;
			handler.getWorld().getEntityManager().getPlayer().getTrivel().setActive(true);
		}

	}

	@SuppressWarnings("deprecation")
	public void render(Graphics g) {
		if (!active) {
			return;
		}
		g.setColor(color);
		g.fillRoundRect(20, 20, handler.getGame().getWidth() - 40, handler.getGame().getHeight() - 40, 40, 40);
		Text.drawString(g, "PlayerInfo", 320, 240, true, Color.GREEN, Assets.smallText);
		
		g.setColor(Color.BLACK);
		g.fillRect(304, 466, 8, 8);
		
		g.fillRect(316, 466, 8, 8);
		
		g.fillRect(328, 466, 8, 8);
		
		g.setColor(Color.WHITE);
		g.fillRect(305, 467, 6, 6);
		g.setColor(Color.BLUE);
		g.fillRect(317, 467, 6, 6);
		g.setColor(Color.WHITE);
		g.fillRect(329, 467, 6, 6);
		
		
	}

	public Handler getHandler() {
		return handler;
	}

	public boolean isActive() {
		return active;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isItemScreen() {
		return itemScreen;
	}

	public void setItemScreen(boolean itemScreen) {
		this.itemScreen = itemScreen;
	}

}
