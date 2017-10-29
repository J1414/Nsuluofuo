package de.thcproductions.nsuluofuo.main;

import java.lang.reflect.GenericArrayType;

public class Launcher {

	public static void main(String[] args) {
		Game game = new Game("NSULUOFUO", 640, 480);
		game.start();
		System.out.println("[Launcher] Nsuluofuo has started");
	}

}
