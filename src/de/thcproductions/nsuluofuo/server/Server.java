package de.thcproductions.nsuluofuo.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private int Port;
	private int MaxClients;
	private ServerSocket Ssocket;
	
	public Server(int pPort, int pMaxClients) {
		
		Port = pPort;
		//ich muss die clients noch z�hlen
		MaxClients = pMaxClients;
		
		start();
		
	}
	public void start() {
		
				try {
					
					Ssocket = new ServerSocket(Port);
					System.out.println("Nsuluofuo Server: Server started. Port: " + Port + ", MaxClients: " + MaxClients);
					
					while (true) {
						
						final Socket Csocket = Ssocket.accept();
						System.out.println("Nsuluofuo Server: Client connected.");
						
						Thread tr = new Thread(){
							public void  run() {
				                
				            	Client cl = new Client(Csocket);
				            	
				            }
				        };
				        tr.start();

					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}
	
	
}
