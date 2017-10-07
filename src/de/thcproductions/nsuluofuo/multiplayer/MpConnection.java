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
		
		String answer = null;
		
		try {
			while ((answer = reader.readLine()) != null) {

				answer = answer + "\n";
				//rtrn += s + "\n";
				
			}
			
			characterList.clear();
			
			while(answer != ""){
				
				characterList.add(new MpCharacter(
						Double.parseDouble(answer.substring(4, answer.indexOf("><1:"))),
						Double.parseDouble(answer.substring(answer.indexOf("><1:"), answer.indexOf("><2:"))),
						Integer.parseInt(answer.substring(answer.indexOf("><3:"), answer.indexOf(">>")))));
				//die lines stimmen noch nicht (paas sachen noch addieren)
				
				answer = answer.substring(answer.indexOf(">>"), answer.length());
				
			}
		} catch(Exception e){
			// muss ich noch machen
			System.out.println("hier");
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
