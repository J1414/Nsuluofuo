package de.thcproductions.nsuluofuo.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable{

	private Socket Csocket;
	
	public Client(Socket pCsocket) {
		Csocket = pCsocket;
		run();
	}

	public void run() {

		try {
			
			OutputStream out = Csocket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);

			InputStream in = Csocket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String s = null;

			while ((s = reader.readLine()) != null) {

				System.out.println("Nsuluofuo Server: Nachricht von Client: " + s);

				writer.write(s + "\n");
				writer.flush();

				s = null;

			}

			writer.close();
			reader.close();

			Csocket.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
