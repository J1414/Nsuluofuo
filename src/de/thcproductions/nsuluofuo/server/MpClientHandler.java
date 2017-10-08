package de.thcproductions.nsuluofuo.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MpClientHandler implements Runnable{
	
	private Socket clientsoc;
	private static String characters = "";
	private static int index = 0;
	
	public MpClientHandler(Socket pclientsoc) {
		clientsoc = pclientsoc;
	}

	@Override
	public void run() {
		
		index ++;
		final int thisIndex = index;
		
		try {

			OutputStream out = clientsoc.getOutputStream();
			PrintWriter writer = new PrintWriter(out);

			InputStream in = clientsoc.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			characters = characters +"(" + thisIndex +  "<<0:0><1:0><2:0><3:->>" +  thisIndex + ")";

			while(true){
			
				String s = null;
	
				while ((s = reader.readLine()) != null) {
					
					String cpt1 = characters.substring(0, characters.indexOf("(" + thisIndex) + 2);
					String cpt2 = characters.substring(characters.indexOf(thisIndex + ")"), characters.length());
					
					characters = cpt1 + s + cpt2;
					
					s = null;
					
					writer.write("["+ thisIndex + "]" + characters + "\n");
					writer.flush();
	
				}
			
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
