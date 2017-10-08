package de.thcproductions.nsuluofuo.modes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.graphics.Text;
import de.thcproductions.nsuluofuo.main.Handler;
import de.thcproductions.nsuluofuo.ui.ClickListener;
import de.thcproductions.nsuluofuo.ui.GUIImageButton;
import de.thcproductions.nsuluofuo.ui.GUIManager;

public class SettingsMode extends Mode{
	
	public SettingsMode(Handler handler) {
		super(handler);
		
		
		
	}

	@Override
	public void update() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)){
			Mode.setMode(handler.getGame().menuMode);
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 640, 480);
		Text.drawString(g, "Settings", 320, 50, true, Color.BLACK, Assets.text);
		
	}

}
