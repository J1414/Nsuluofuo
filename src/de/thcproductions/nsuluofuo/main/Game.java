package de.thcproductions.nsuluofuo.main;

import java.awt.Graphics;

import java.awt.image.BufferStrategy;

import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.graphics.GameCamera;
import de.thcproductions.nsuluofuo.gui.Display;
import de.thcproductions.nsuluofuo.input.KeyManager;
import de.thcproductions.nsuluofuo.input.MouseManager;
import de.thcproductions.nsuluofuo.modes.GameMode;
import de.thcproductions.nsuluofuo.modes.MenuMode;
import de.thcproductions.nsuluofuo.modes.Mode;
import de.thcproductions.nsuluofuo.modes.SettingsMode;
import de.thcproductions.nsuluofuo.multiplayer.SimpleDualPlayer;

public class Game implements Runnable {

	private Display display;

	private Thread thread;
	public String title;
	private int width, height;
	private boolean running;
	private BufferStrategy bufferStrategy;
	private Graphics g;
	private KeyManager keyManager;
	private Handler handler;
	private int ticks;

	// States

	public Mode gameMode;
	public Mode menuMode;
	public Mode settingsMode;
	public Mode dialogMode;


	private MouseManager mouseManager;

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	private GameCamera gameCamera;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();

	}

	private void initialize() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.initialize();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		gameMode = new GameMode(handler);
		menuMode = new MenuMode(handler);
		settingsMode = new SettingsMode(handler);
		
		Mode.setMode(menuMode);

	}

	private void update() {
		keyManager.update();
		if (Mode.getMode() != null) {
			Mode.getMode().update();
		}
		
		// Vorübergehende Methode zum Dualplayer-Daten überall verteilen
		SimpleDualPlayer.update();
	}

	private void render() {
		bufferStrategy = display.getCanvas().getBufferStrategy();
		if (bufferStrategy == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, width, height);

		if (Mode.getMode() != null) {
			Mode.getMode().render(g);
		}

		bufferStrategy.show();
		g.dispose();

	}

	public void run() {
		initialize();
		int fps = 60;
		double timePerUpdate = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		ticks = 0;

		while (isRunning()) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerUpdate;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public synchronized void start() {
		if (isRunning()) {
			return;
		}
		setRunning(true);
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!isRunning()) {
			return;
		}
		setRunning(true);
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Mode getMenuMode() {
		return menuMode;
	}

	public void setMenuMode(Mode menuMode) {
		this.menuMode = menuMode;
	}

	public int getTicks() {
		return ticks;
	}

	public void setTicks(int ticks) {
		this.ticks = ticks;
	}
	
	
	
	

}
