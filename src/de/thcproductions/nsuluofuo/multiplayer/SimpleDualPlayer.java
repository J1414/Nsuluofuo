package de.thcproductions.nsuluofuo.multiplayer;

import de.thcproductions.nsuluofuo.server.MpServer;

public class SimpleDualPlayer {
	
	private static MpServer server;
	private static MpConnection connection;
	private static MpCharacter playerL;
	private static MpCharacter playerR;
	
	private static int port;

	public static void startServer(int pport){
		port = pport;
		server = new MpServer(pport);
		server.start();
	}
	public static void stopServer(){
		server.stop();
	}
	public static void join(String phost, int pport){
		playerL = new MpCharacter(0, 0, 0, "Player");
		connection = new MpConnection(phost, pport, playerL);
		connection.start();
	}
	public static void join(){
		playerL = new MpCharacter(0, 0, 0, "Player");
		connection = new MpConnection("localhost", port, playerL);
		connection.start();
	}
	public static void disconnect(){
		connection.stop();
	}
	public static void update(){
		connection.update();
	}
	
	/*public static boolean isReady(){
		connection.update();
		if(connection.getCharacterList().size() > 1){
			return true;
		}
		else {
			return false;
		}
	}
	
	public static MpCharacter getPlayerL() {
		connection.update();
		return playerL;
	}
	public static MpCharacter getPlayerR() {
		connection.update();
		if(connection.getLocalPlayer().getId() == 0){
			playerR = connection.getCharacter(1);
		}
		else if(connection.getLocalPlayer().getId() == 1){
			playerR = connection.getCharacter(0);
		}
		return playerR;
	}*/
}

				
		//conn.update(); daten vom lokalen speiler werden hochgeladen, allse anderern spieler werden runtergeladen und in clientliste gespeichert / auﬂerdem weist der server dem lokalen spieler seine id zu
		//System.out.println("Ausgabe: " + conn.getCharacter(2).getName()); name von spieler mit der id 2 ausgeben
		//System.out.println("Ausgabe 2: " + conn.getLocalPlayer().getId()); id vom lokalen spieler ausgeben