package de.thcproductions.nsuluofuo.server;

// Felix @ THC Productions 5.10.2017
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import de.thcproductions.nsuluofuo.multiplayer.MpCharacter;

public class MpClientHandler implements Runnable{
	
	private Socket clientsoc;
	private static ArrayList<MpCharacter> characterList;
	private static int anz = 0;
	private int index = 0;
	
	public MpClientHandler(Socket pclientsoc) {
		clientsoc = pclientsoc;
	}

	@Override
	public void run() {

		try {
			
			index = anz + 1;
			anz = anz + 1;
			
			characterList.add(new MpCharacter(0, 0, 0));

			OutputStream out = clientsoc.getOutputStream();
			PrintWriter writer = new PrintWriter(out);

			InputStream in = clientsoc.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String s = null;

			while ((s = reader.readLine()) != null) {

				characterList.set(index, new MpCharacter(
						Double.parseDouble(s.substring(4, s.indexOf("><1:"))),
						Double.parseDouble(s.substring(s.indexOf("><1:"), s.indexOf("><2:"))),
						Integer.parseInt(s.substring(s.indexOf("><3:"), s.indexOf(">>")))));
				//die lines stimmen noch nicht (paas sachen noch addieren) gleiche wie in mpconnection / mayb müssen neue zeilen hin bei fehlern

				String answer = "";
				
				for (int i = 0; i < characterList.size(); i++){
					
					answer = answer + "<<0:" + characterList.get(i).getPositionX() + "><1:" + characterList.get(i).getPositionY() + "><2:" + characterList.get(i).getBlickrichtung() + ">>";
					
				}
				
				writer.write(answer);
				writer.flush();

				s = null;

			}

			writer.close();
			reader.close();

			clientsoc.close();

		} catch (IOException e) {
			System.out.println("oder mayb auch hier");
			e.printStackTrace();
		}
		
	}

}
