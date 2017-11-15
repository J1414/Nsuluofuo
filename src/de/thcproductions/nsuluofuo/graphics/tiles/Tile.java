package de.thcproductions.nsuluofuo.graphics.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Tile {

	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	protected Rectangle bounds;
	private int width, height;
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile highGrass = new HighGrassTile(1);
	public static Tile water = new WaterTile(2);
	public static Tile path = new PathTile(3);
	public static Tile stone = new StoneTile(4);
	public static Tile middleWall = new MiddleWallTile(5);
	
	public static Tile luc = new LeftUpperCornerTile(6);
	public static Tile lbc = new LeftBottomCornerTile(7);
	public static Tile ruc = new RightUpperCornerTile(8);
	public static Tile rbc = new RightBottomCornerTile(9);
	public static Tile cliffDown = new CliffDownTile(10);
	public static Tile cliffUp = new CliffUpTile(11);
	public static Tile cliffLeft = new CliffLeftTile(12);
	public static Tile cliffRight = new CliffRightTile(13);
	public static Tile bridge = new BridgeTile(14);
	public static Tile mossyWall = new MossyWallTile(15);
	public static Tile mossyWallLeft = new MossyWallLeftTile(16);
	public static Tile mossyWallRight = new MossyWallRightTile(17);
	public static Tile leftWall = new LeftWallTile(18);
	public static Tile rightWall = new RightWallTile(19);
	public static Tile stoneBright = new StoneTopTile(20);
	public static Tile gate = new GateTile(21);
	//
	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id, int width, int height) {
		this.texture = texture;
		this.id = id;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(0, 0, width, height);
		tiles[id] = this;
	}

	public void update() {

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	public boolean isSolid() {
		return false;
	}

	public int getId() {
		return id;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
}
