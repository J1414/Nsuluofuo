package de.thcproductions.nsuluofuo.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;
	public static BufferedImage grass, highGrass, tree, water, bridge, largeRock, rock, path, stone, stoneBright, gate,
			middleWall, mossyWall, mossyWallLeft, mossyWallRight, leftWall, rightWall, cliffDown, cliffUp, cliffLeft,
			cliffRight, leftUpperCorner, leftBottomCorner, rightUpperCorner, rightBottomCorner;

	public static BufferedImage playerDown, playerUp, playerLeft, playerRight;
	public static BufferedImage mNpcUp, mNpcDown, mNpcLeft, mNpcRight, fNpcUp, fNpcDown, fNpcLeft, fNpcRight;
	
	public static BufferedImage heart, hheart;

	public static BufferedImage trivel, money, triviartefakt, dsword, msword, tsword;
	public static BufferedImage[] start_btn, close_button, settings_button, player_down, player_up, player_left,
			player_right;
	public static Font head, text, smallText;
	public static BufferedImage background;
	public static BufferedImage gameO;
	public static BufferedImage ivo;
	public static BufferedImage thc;

	public static void initialize() {

		head = FontLoader.loadFont("res/fonts/saoFont.ttf", 128);
		text = FontLoader.loadFont("res/fonts/saoFont.ttf", 64);
		smallText = FontLoader.loadFont("res/fonts/saoFont.ttf", 24);
		
		SpriteSheet player = new SpriteSheet(ImageLoader.loadImage("/textures/Player.png"));
		SpriteSheet npc = new SpriteSheet(ImageLoader.loadImage("/textures/NPC.png"));
		SpriteSheet terrain = new SpriteSheet(ImageLoader.loadImage("/textures/terrain.png"));
		SpriteSheet items = new SpriteSheet(ImageLoader.loadImage("/textures/Items.png"));
		SpriteSheet gui = new SpriteSheet(ImageLoader.loadImage("/textures/GUI.png"));
		SpriteSheet uli = new SpriteSheet(ImageLoader.loadImage("/textures/uli.jpg"));
		SpriteSheet thct = new SpriteSheet(ImageLoader.loadImage("/textures/THC Schriftzug.png"));
		SpriteSheet health = new SpriteSheet(ImageLoader.loadImage("/textures/health.png"));

		/* big pictures */
			
		ivo = uli.split(0, 0, 640, 480);
		thc = thct.split(0,0, 100, 80);
		
		/* Health*/
		
		heart = health.split(0, 0, 16, 16);
		hheart = health.split(16,0,16,16);

		/* GUI */
		start_btn = new BufferedImage[2];
		start_btn[0] = gui.split(0, 0, 4 * width, 2 * height);
		start_btn[1] = gui.split(0, 2 * height, 4 * width, 2 * height);

		close_button = new BufferedImage[2];
		close_button[0] = gui.split(0, 4 * height, 4 * width, 2 * height);
		close_button[1] = gui.split(0, 6 * height, 4 * width, 2 * height);

		settings_button = new BufferedImage[2];
		settings_button[0] = gui.split(0, 8 * height, 4 * width, 2 * height);
		settings_button[1] = gui.split(0, 10 * height, 4 * width, 2 * height);

		/* Animations */
		player_down = new BufferedImage[2];
		player_down[0] = player.split(0, 0, width, height);
		player_down[1] = player.split(2 * width, 0, width, height);

		player_up = new BufferedImage[2];
		player_up[0] = player.split(0, 3 * height, width, height);
		player_up[1] = player.split(2 * width, 3 * height, width, height);

		player_left = new BufferedImage[2];
		player_left[0] = player.split(0, height, width, height);
		player_left[1] = player.split(2 * width, height, width, height);

		player_right = new BufferedImage[2];
		player_right[0] = player.split(0, 2 * height, width, height);
		player_right[1] = player.split(2 * width, 2 * height, width, height);

		/* Items */
		
		trivel = items.split(0, 0, width, height);
		money = items.split(0, height, width, height);
		triviartefakt = items.split(0, 2* height, width, height);
		dsword = items.split(width, 0, width, height);
		msword = items.split(width, height, width, height);
		tsword = items.split(width, 2 * height, width, height);
		

		/* Entities */

		tree = terrain.split(2 * width, 2* height, width, 2 * height);
		rock = terrain.split(3 * width, 0, width, height);
		largeRock = terrain.split(3 * width, 2 * height, width, 2 * height);

		/* Player */
		playerDown = player.split(width, 0, width, height);
		playerLeft = player.split(width, 1 * height, width, height);
		playerRight = player.split(width, 2 * height, width, height);
		playerUp = player.split(width, 3 * height, width, height);

		/* NPC's */

		// female
		fNpcDown = npc.split(0, 0, width, height);
		fNpcLeft = npc.split(0, height, width, height);
		fNpcRight = npc.split(0, 2 * height, width, height);
		fNpcUp = npc.split(0, 3 * height, width, height);

		// male
		mNpcDown = npc.split(width, 0, width, height);
		mNpcLeft = npc.split(width, height, width, height);
		mNpcRight = npc.split(width, 2 * height, width, height);
		mNpcUp = npc.split(width, 3 * height, width, height);

		/* Tiles */
		grass = terrain.split(0, 0, width, height);
		highGrass = terrain.split(width, 0, width, height);
		water = terrain.split(0, height, width, height);
		bridge = terrain.split(0, height, width, height);
		path = terrain.split(width, height, width, height);
		stone = terrain.split(3 * width, height, width, height);
		stoneBright = terrain.split(7 * width, height, width, height);
		gate = terrain.split(7 * width, 2 * height, width, height);
		middleWall = terrain.split(6 * width, 0, width, height);
		cliffDown = terrain.split(6 * width, 2 * height, width, height);
		cliffUp = terrain.split(6 * width, height, width, height);
		cliffLeft = terrain.split(6 * width, 3 * height, width, height);
		cliffRight = terrain.split(6 * width, 4 * height, width, height);
		leftUpperCorner = terrain.split(4 * width, 0, width, height);
		leftBottomCorner = terrain.split(4 * width, height, width, height);
		rightUpperCorner = terrain.split(5 * width, 0, width, height);
		rightBottomCorner = terrain.split(5 * width, height, width, height);
		mossyWall = terrain.split(7 * width, 0, width, height);
		mossyWallLeft = terrain.split(4 * width, 4 * height, width, height);
		mossyWallRight = terrain.split(5 * width, 4 * height, width, height);
		leftWall = terrain.split(4 * width, 2 * height, width, height);
		rightWall = terrain.split(5 * width, 2 * height, width, height);

	}

}
