package de.thcproductions.nsuluofuo.worlds;

import java.awt.Graphics;

import de.thcproductions.nsuluofuo.creatures.NPC;
import de.thcproductions.nsuluofuo.creatures.Player;
import de.thcproductions.nsuluofuo.creatures.Player2;
import de.thcproductions.nsuluofuo.entities.EntityManager;
import de.thcproductions.nsuluofuo.graphics.tiles.Tile;
import de.thcproductions.nsuluofuo.item.ItemManager;
import de.thcproductions.nsuluofuo.main.Handler;
import de.thcproductions.nsuluofuo.statics.Tree;
import de.thcproductions.nsuluofuo.utils.Utils;

public class World {

	private int width, height;
	private int spawnX, spawnY;
	private int spawnX2, spawnY2;
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

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		
		itemManager = new ItemManager(handler);
		
		entityManager.addEntity(new Player2(handler, 10, 2));
		
		/* Statics */
		
		drawTrees();
		
		//Mobs
		
		drawMobs();
		
		//NPC's
		
		entityManager.addEntity(new NPC(handler, 6, 3, "Deine Mutter", "Ich hasse dich"));
		
		//Buildings
		
		
		
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX * entityManager.getPlayer().getWidth());
		entityManager.getPlayer().setY(spawnY * entityManager.getPlayer().getWidth());
	}
	
	private void drawTrees(){
		entityManager.addEntity(new Tree(handler, 10, 10, width, height));
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

}
