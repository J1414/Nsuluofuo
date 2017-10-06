package de.thcproductions.nsuluofuo.statusscreens;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.main.Handler;

public class Congratulation {
	private boolean active = false;
	private Handler handler;

	public Congratulation(Handler handler) {
		this.handler = handler;

	}

	public void update() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_L)){
			setActive(true);
		}
//		setActive(true);
//		if (active && handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)) {
//			setActive(false);
//
//		}

	}

	public void render(Graphics g) {
		if (!active) {
			return;
		} else {
			g.drawImage(Assets.gameO, 0, 0, null);
		}
		
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
