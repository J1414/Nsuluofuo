package de.thcproductions.nsuluofuo.main;

import de.thcproductions.nsuluofuo.server.MpServer;

public class Launcher {

	public static void main(String[] args) {
		Game game = new Game("NSULUOFUO", 640, 480);
		game.start();
	}

}
