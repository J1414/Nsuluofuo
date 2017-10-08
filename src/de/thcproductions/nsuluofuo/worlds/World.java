package de.thcproductions.nsuluofuo.worlds;

import java.awt.Graphics;

import de.thcproductions.nsuluofuo.creatures.NPC;
import de.thcproductions.nsuluofuo.creatures.Player;
import de.thcproductions.nsuluofuo.creatures.Player2;
import de.thcproductions.nsuluofuo.entities.EntityManager;
import de.thcproductions.nsuluofuo.graphics.tiles.Tile;
import de.thcproductions.nsuluofuo.item.ItemManager;
import de.thcproductions.nsuluofuo.main.Handler;
import de.thcproductions.nsuluofuo.statics.Ganja;
import de.thcproductions.nsuluofuo.statics.Tree;
import de.thcproductions.nsuluofuo.utils.Utils;

public class World {

	private int width, height;
	private int spawnX, spawnY;
	private int spawnX2, spawnY2;
	private String name, name2;
	private int health, health2;
	private int[][] tiles;
	private Handler handler;
	private EntityManager entityManager;

	private ItemManager itemManager;

	public void update() {
		entityManager.update();
		itemManager.update();
	}

	public void render(Graphics g) {

		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		itemManager.render(g);
		entityManager.render(g);
	}

	public Tile getTile(int x, int y) {

		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.grassTile;
		}

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			return Tile.grassTile;
		}
		return t;
	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		spawnX2 = Utils.parseInt(tokens[4]);
		spawnY2 = Utils.parseInt(tokens[5]);
		name = tokens[6];
		name2 = tokens[7];
	
		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 8]);
			}
		}
	}

	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, spawnX, spawnY), new Player2(handler, spawnX2, spawnY2));
		
		itemManager = new ItemManager(handler);
		
		/* Statics */
		
		drawTrees();
		
		//Mobs
		
		drawMobs();
		
		//NPC's
		
		entityManager.addEntity(new NPC(handler, 6, 3, "Deine Mutter", "Ich hasse dich"));
		
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX * entityManager.getPlayer().getWidth());
		entityManager.getPlayer().setY(spawnY * entityManager.getPlayer().getWidth());
		
		entityManager.getPlayer2().setX(spawnX2 * entityManager.getPlayer2().getWidth());
		entityManager.getPlayer2().setY(spawnY2 * entityManager.getPlayer2().getWidth());
		
		System.out.println("Player1: " + name + " > "  + health  + "\nPlayer2: " + name2 + " > " + health2);
	}
	
	private void drawTrees(){
		entityManager.addEntity(new Tree(handler, 6, 0, width, height));
		entityManager.addEntity(new Ganja(handler, 7, 0, width, height));
		entityManager.addEntity(new Tree(handler, 7, 1, width, height));
		entityManager.addEntity(new Ganja(handler, 8, 2, width, height));
		entityManager.addEntity(new Tree(handler, 9, 2, width, height));
		entityManager.addEntity(new Ganja(handler, 10,3, width, height));
		entityManager.addEntity(new Ganja(handler, 11,3, width, height));
		entityManager.addEntity(new Ganja(handler, 11,13, width, height));

	}
	
	private void drawMobs(){
		
		
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Handler getHandler() {
		return handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealth2() {
		return health2;
	}

	public void setHealth2(int health2) {
		this.health2 = health2;
	}
	
	

}
