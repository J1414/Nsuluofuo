package de.thcproductions.nsuluofuo.multiplayer;

import java.io.BufferedReader;
import java.io.IOException;
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
	
	private String host;
	private int port;
	
	private ArrayList<MpCharacter> characterList;
	private MpCharacter localPlayer;
	
	public MpConnection(String phost, int pport, MpCharacter plocalPlayer){
		try {
			
			host = phost;
			port = pport;
			
			characterList = new ArrayList<MpCharacter>();
			localPlayer = plocalPlayer;
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start(){
		try {	
			
			soc = new Socket(host, port);
			
			in = soc.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			
			out = soc.getOutputStream();
			writer = new PrintWriter(out);
			
			System.out.println("Client: Connected to server");
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void stop(){
		try {
			
			soc.close();
			System.out.println("Client: Socket closed");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(){
		
		writer.write("<<0:" + localPlayer.getPositionX() + "><1:" + localPlayer.getPositionY() + "><2:" + localPlayer.getDir() + "><3:" + localPlayer.getName() + ">>\n");
		writer.flush();
		
		try {
			String line = reader.readLine();
				
				characterList.clear();
				
				localPlayer.setId(Integer.parseInt(line.substring(line.indexOf("[") + 1, line.indexOf("]"))) - 1);
				
				for(int i = 0; i < Integer.parseInt(line.substring(line.length() - 2, line.length() - 1)); i++){
					characterList.add(new MpCharacter(
					Double.parseDouble(line.substring(line.indexOf("<<0:") + 4, line.indexOf("><1:"))),
					Double.parseDouble(line.substring(line.indexOf("><1:") + 4, line.indexOf("><2:"))),
					Integer.parseInt(line.substring(line.indexOf("><2:") + 4, line.indexOf("><3:"))),
					line.substring(line.indexOf("><3:") + 4, line.indexOf(">>"))));
					
					line = line.substring(line.indexOf(">>") + 2, line.length());
				}
				
				line = null;
				
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
	
	public MpCharacter getCharacter(int id){
		
		return characterList.get(id);
	}

	public MpCharacter getLocalPlayer() {
		return localPlayer;
	}

	public void setLocalPlayer(MpCharacter localPlayer) {
		this.localPlayer = localPlayer;
	}
	
	

}
