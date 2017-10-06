package de.thcproductions.nsuluofuo.main;

import java.awt.Color;

import de.thcproductions.nsuluofuo.graphics.GameCamera;
import de.thcproductions.nsuluofuo.input.KeyManager;
import de.thcproductions.nsuluofuo.input.MouseManager;
import de.thcproductions.nsuluofuo.modes.Mode;
import de.thcproductions.nsuluofuo.worlds.World;

public class Handler {

	private Game game;
	private World world;
	private Mode mode;
	private Color color;

	public Handler(Game game) {
		this.game = game;
		color = new Color(255,255,255,200);
	
	}

	public int getWidth() {
		return game.getWidth();
	}

	public int getHeight() {
		return game.getHeight();
	}

	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	


}
