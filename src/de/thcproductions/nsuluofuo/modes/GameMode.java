package de.thcproductions.nsuluofuo.modes;

import java.awt.Color;
import java.awt.Graphics;

import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.input.KeyManager;
import de.thcproductions.nsuluofuo.inventory.Dialog;
import de.thcproductions.nsuluofuo.main.Handler;
import de.thcproductions.nsuluofuo.ui.GUIManager;
import de.thcproductions.nsuluofuo.worlds.World;

public class GameMode extends Mode {


	private World world;

	private KeyManager keyManager;
	private String text, name;
	private GUIManager guiManager;
	private MenuMode menumode;
	private Color daycolor;

	public GameMode(Handler handler) {
		super(handler);
		guiManager = new GUIManager(handler);
		keyManager = new KeyManager();
		world = new World(handler, "res/worlds/world1.txt");
		text = Dialog.text;
		name = Dialog.name;
		handler.setWorld(world);
		
		
	}

	@Override
	public void update() {
		world.update();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		switch((handler.getWorld().getEntityManager().getPlayer().getHealth())) {
		case 0: return;
		case 1: g.drawImage(Assets.hheart, 5, 5, null);
		break;
		case 2: g.drawImage(Assets.heart, 5, 5, null);
		break;
		case 3: case 5: case 7: case 9: case 11: case 13: case 15: case 17: case 19: for(int i = 0; i < ((handler.getWorld().getEntityManager().getPlayer().getHealth() -1) /2 ); i++) {
			g.drawImage(Assets.heart, 5 + 16*i, 5, null);
		}
			g.drawImage(Assets.hheart, 5+16*((handler.getWorld().getEntityManager().getPlayer().getHealth()-1)/2), 5, null);
		break;
		case 4: case 6: case 8: case 10: case 12: case 14: case 16: case 18: case 20: for(int i = 0; i < handler.getWorld().getEntityManager().getPlayer().getHealth() / 2; i++) {
			g.drawImage(Assets.heart, 5 + 16*i, 5, null);
		}
		break;
		}
		Dialog.render(g);
		handler.getWorld().getEntityManager().getPlayer().getTrivel().render(g);
		handler.getWorld().getEntityManager().getPlayer().getInventory().render(g);
		handler.getWorld().getEntityManager().getPlayer().getInfo().render(g);
	
	}

}
