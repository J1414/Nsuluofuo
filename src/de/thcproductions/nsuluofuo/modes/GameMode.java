package de.thcproductions.nsuluofuo.modes;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import de.thcproductions.nsuluofuo.input.KeyManager;
import de.thcproductions.nsuluofuo.main.Handler;
import de.thcproductions.nsuluofuo.worlds.World;

public class GameMode extends Mode {


	private World world;

	private KeyManager keyManager;



	public GameMode(Handler handler) {
		super(handler);
		keyManager = new KeyManager();
		world = new World(handler, "res/worlds/world1.txt");
		
		handler.setWorld(world);
		
		
	}

	@Override
	public void update() {
		world.update();
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)){
			Mode.setMode(handler.getGame().settingsMode);
		}
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	
	}

}
