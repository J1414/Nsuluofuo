package de.thcproductions.nsuluofuo.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import de.thcproductions.nsuluofuo.main.Handler;

public class Trivel {
	
	private Handler handler;
	private Graphics g;
	private boolean active;
	
	public Trivel(Handler handler){
		this.handler = handler;
		
	}
	
	public void update(){
		if (!active) {
			return;
		}
		
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
			
			active = !active;
			
		}
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT)){
			active = !active;
			handler.getWorld().getEntityManager().getPlayer().getInfo().setActive(true);
		}
		
	}
	
	public void render(Graphics g){
		if (!active) {
			return;
		}
		g.setColor(Color.BLUE);
		g.fillRoundRect(20, 20, 600, 440,5,5);
		g.setColor(Color.WHITE);
		g.fillRoundRect(30, 30, 580, 420, 5, 5);
		g.setColor(Color.BLACK);
		g.drawLine(319, 30, 319, 450);
		
		g.setColor(Color.BLACK);
		g.fillRect(304, 471, 8, 8);
		
		g.fillRect(316, 471, 8, 8);
		
		g.fillRect(328, 471, 8, 8);
		
		g.setColor(Color.BLUE);
		g.fillRect(305, 472, 6, 6);
		g.setColor(Color.WHITE);
		g.fillRect(317, 472, 6, 6);
		g.setColor(Color.WHITE);
		g.fillRect(329, 472, 6, 6);
		
		
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
