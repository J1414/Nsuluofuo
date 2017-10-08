package de.thcproductions.nsuluofuo.multiplayer;

// Felix @ THC Productions 5.10.2017
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MpConnection {
	private Socket soc;
	private InputStream in;
	private BufferedReader reader;
	private OutputStream out;
	private PrintWriter writer;
	
	private ArrayList<MpCharacter> characterList;
	private MpCharacter localPlayer;
	
	
	public MpConnection(String phost, int pport, MpCharacter plocalPlayer){
		try {
			
			characterList = new ArrayList<MpCharacter>();
			localPlayer = plocalPlayer;
			
			soc = new Socket(phost, pport);
			
			in = soc.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			
			out = soc.getOutputStream();
			writer = new PrintWriter(out);
			
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("oder hier");
		}
	}

	public void update(){
		
		
		writer.write("<<0:" + localPlayer.getPositionX() + "><1:" + localPlayer.getPositionY() + "><2:" + localPlayer.getBlickrichtung() + ">>\n");
		writer.flush();
		
		System.out.println("selber gsend");
		
		
		
		try {
			String line = reader.readLine();
			//while ((line = reader.readLine()) != null) {

				System.out.println("line da: " + line);
				
				characterList.clear();
				
				for(int i = 0; i < Integer.parseInt(line.substring(line.length() - 2, line.length() - 1)); i++){
					characterList.add(new MpCharacter(
					Double.parseDouble(line.substring(line.indexOf("<<0:") + 4, line.indexOf("><1:"))),
					Double.parseDouble(line.substring(line.indexOf("><1:") + 4, line.indexOf("><2:"))),
					Integer.parseInt(line.substring(line.indexOf("><2:") + 4, line.indexOf(">>")))));
					
					System.out.println("1 chrhktrt geklärt");
					
					line = line.substring(line.indexOf(">>") + 2, line.length());
				}
				
				

				
				line = null;
				
			//}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		

		
	}

	public ArrayList<MpCharacter> getCharacterList() {
		return characterList;
	}

	public void setCharacterList(ArrayList<MpCharacter> characterList) {
		this.characterList = characterList;
	}

	public MpCharacter getLocalPlayer() {
		return localPlayer;
	}

	public void setLocalPlayer(MpCharacter localPlayer) {
		this.localPlayer = localPlayer;
	}
	
	

}
