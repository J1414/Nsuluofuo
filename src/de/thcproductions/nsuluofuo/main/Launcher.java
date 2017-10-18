package de.thcproductions.nsuluofuo.main;

import de.thcproductions.nsuluofuo.multiplayer.SimpleDualPlayer;

public class Launcher {

	public static void main(String[] args) {
		Game game = new Game("NSULUOFUO", 640, 480);
		game.start();
		
		//Server beitreten
		SimpleDualPlayer.join("84.200.109.107", 1442);
		
	}

}
