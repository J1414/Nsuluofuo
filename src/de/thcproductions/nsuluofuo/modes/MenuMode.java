package de.thcproductions.nsuluofuo.modes;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;

import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.graphics.Text;
import de.thcproductions.nsuluofuo.main.Handler;
import de.thcproductions.nsuluofuo.ui.ClickListener;
import de.thcproductions.nsuluofuo.ui.GUIImageButton;
import de.thcproductions.nsuluofuo.ui.GUIManager;

public class MenuMode extends Mode {
	
	private GUIManager guiManager;
	private JTextField textField;
	private JPanel contentPane;
	
	public MenuMode(Handler handler) {
		super(handler);
		textField = new JTextField();
		guiManager = new GUIManager(handler);
		handler.getMouseManager().setGUIManager(guiManager);
		
		guiManager.addObject(new GUIImageButton(256, 158, 128, 64, Assets.start_btn, new ClickListener(){
		
	
			@Override
			public void onClick() {
				handler.getMouseManager().setGUIManager(null);
				Mode.setMode(handler.getGame().gameMode);
				
			}}));
		
		guiManager.addObject(new GUIImageButton(256, 258, 128, 64, Assets.close_button, new ClickListener(){
			
			
			@Override
			public void onClick() {
				handler.getMouseManager().setGUIManager(null);
				System.exit(0);
				
			}}));
		
		guiManager.addObject(new GUIImageButton(256, 358, 128, 64, Assets.settings_button, new ClickListener(){
			
			
			@Override
			public void onClick() {
				Mode.setMode(handler.getGame().settingsMode);
				
			}}));
	}

	

	@Override
	public void update() {
		guiManager.update();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 640, 480);
		g.drawImage(Assets.ivo, 0, 0, null);
		g.drawImage(Assets.thc, 0, 400, null);
		Text.drawString(g, "NSULUOFUO", 320, 100, true, Color.WHITE, Assets.head);
		guiManager.render(g);
		
	}



	public GUIManager getGuiManager() {
		return guiManager;
	}



	public void setGuiManager(GUIManager guiManager) {
		this.guiManager = guiManager;
	}
	
	
}
