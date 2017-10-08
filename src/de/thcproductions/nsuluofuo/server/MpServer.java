package de.thcproductions.nsuluofuo.server;

// Felix @ THC Productions 5.10.2017
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import de.thcproductions.nsuluofuo.multiplayer.MpCharacter;

public class MpServer {
	private ServerSocket serversoc;
	
	public MpServer(int pport){
		
		try {
			
			serversoc = new ServerSocket(pport);
			
			while(true){
			
				Socket clientsoc = serversoc.accept();
				Thread tr = new Thread(new MpClientHandler(clientsoc));
				tr.start();
				
				System.out.println("Server: Client verbunden");
				
			}
			
		} catch (Exception e) {
			System.out.println("vielleicht auch hier ");
			e.printStackTrace();
		}
		
	}
}
