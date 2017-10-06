package de.thcproductions.nsuluofuo.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import de.thcproductions.nsuluofuo.main.Handler;

public class GUIManager {
	
	private Handler handler;
	private ArrayList<GUIObject> objects;
	
	public GUIManager(Handler handler){
		this.handler = handler;
		objects = new ArrayList<GUIObject>();
	}
	
	public void update(){
		for(GUIObject o : objects){
			o.update();
		}
	}
	
	public void render(Graphics g){
		for(GUIObject o : objects){
			o.render(g);
		}
	}
	
	public void onMouseMove(MouseEvent e){
		for(GUIObject o : objects){
			o.onMouseMove(e);
		}
	}
	
	public void onMouseRelease(MouseEvent e){
		for(GUIObject o : objects){
			o.onMouseRelease(e);
		}
	}
	
	public void addObject(GUIObject o){
		objects.add(o);
	}
	
	public void removeObject(GUIObject o){
		objects.remove(o);
	}
	
	public Handler getHandler(){
		return handler;
	}
	
	public void setHandler(Handler handler){
		this.handler = handler;
	}
	
	public ArrayList<GUIObject> getObjects(){
		return objects;
	}
	
	public void setObjects(ArrayList<GUIObject> objects){
		this.objects = objects;
	}

}
