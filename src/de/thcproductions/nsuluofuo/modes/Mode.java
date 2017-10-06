package de.thcproductions.nsuluofuo.modes;

import java.awt.Graphics;

import de.thcproductions.nsuluofuo.main.Handler;

public abstract class Mode {

	private static Mode currentMode = null;

	public static void setMode(Mode mode) {
		currentMode = mode;
	}

	public static Mode getMode() {
		return currentMode;
	}

	//
	protected Handler handler;

	public Mode(Handler handler) {
		this.handler = handler;
	}

	public abstract void update();

	public abstract void render(Graphics g);

}
