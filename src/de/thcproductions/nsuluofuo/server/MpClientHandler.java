package de.thcproductions.nsuluofuo.server;



// Felix @ THC Productions 5.10.2017
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
		System.out.println("Neuer Index: " + index);

		try {
			

			OutputStream out = clientsoc.getOutputStream();
			PrintWriter writer = new PrintWriter(out);

			InputStream in = clientsoc.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			characters = characters +"(" + thisIndex +  "<<0:0><1:0><2:0>>" +  thisIndex + ")";

			while(true){
			
				String s = null;
	
				while ((s = reader.readLine()) != null) {
					
					System.out.println(s);
	
					System.out.println(s.substring(4, s.indexOf("><1:")));
					System.out.println(s.substring(s.indexOf("><1:") + 4, s.indexOf("><2:")));
					System.out.println(s.substring(s.indexOf("><2:") + 4, s.indexOf(">>")));
					
					String cpt1 = characters.substring(0, characters.indexOf("(" + thisIndex) + 2);
					String cpt2 = characters.substring(characters.indexOf(thisIndex + ")"), characters.length());
					
					characters = cpt1 + s + cpt2;
					
					System.out.println("Characters: " + characters);
					
					/*icharacterList.set(index, new MpCharacter(
							Double.parseDouble(s.substring(4, s.indexOf("><1:"))),
							Double.parseDouble(s.substring(s.indexOf("><1:") + 4, s.indexOf("><2:"))),
							Integer.parseInt(s.substring(s.indexOf("><2:") + 4, s.indexOf(">>")))));*/
					//die lines stimmen noch nicht (paas sachen noch addieren) gleiche wie in mpconnection / mayb müssen neue zeilen hin bei fehlern
					
					s = null;
					
					writer.write(characters + "\n");
					writer.flush();
	
				}
			
			}
			

			//writer.close();
			//reader.close();

			//clientsoc.close();

		} catch (IOException e) {
			System.out.println("oder mayb auch hier");
			e.printStackTrace();
		}
		
	}

}
