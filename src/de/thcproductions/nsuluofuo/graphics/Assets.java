package de.thcproductions.nsuluofuo.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;
	public static BufferedImage grass, highGrass, tree, tree2,ganja, sGanja, rGanja, water, bridge, largeRock, rock, path, stone, stoneBright, gate,
			middleWall, mossyWall, mossyWallLeft, mossyWallRight, leftWall, rightWall, cliffDown, cliffUp, cliffLeft,
			cliffRight, leftUpperCorner, leftBottomCorner, rightUpperCorner, rightBottomCorner;

	public static BufferedImage playerDown, playerUp, playerLeft, playerRight;
	public static BufferedImage iMDown, iMUp, iMLeft, iMRight;
	public static BufferedImage mNpcUp, mNpcDown, mNpcLeft, mNpcRight, fNpcUp, fNpcDown, fNpcLeft, fNpcRight;
	
	public static BufferedImage heart, hheart;

	public static BufferedImage trivel, money, triviartefakt, dsword, msword, tsword, jibbet, monster;
	public static BufferedImage[] start_btn, close_button, settings_button, player_down, player_up, player_left,
			player_right, ivo_down, ivo_left, ivo_right, ivo_up, watera;
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
		SpriteSheet mal = new SpriteSheet(ImageLoader.loadImage("/textures/Cofezuwo.png"));
		SpriteSheet aWater = new SpriteSheet(ImageLoader.loadImage("/textures/Water.png"));

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
		
		ivo_down = new BufferedImage[2];
		ivo_down[0] = mal.split(0, 0, width, height);
		ivo_down[1] = mal.split(2 * width, 0, width, height);

		player_up = new BufferedImage[2];
		player_up[0] = player.split(0, 3 * height, width, height);
		player_up[1] = player.split(2 * width, 3 * height, width, height);
		
		ivo_up = new BufferedImage[2];
		ivo_up[0] = mal.split(0, 3 * height, width, height);
		ivo_up[1] = mal.split(2 * width, 3 * height, width, height);

		player_left = new BufferedImage[2];
		player_left[0] = player.split(0, height, width, height);
		player_left[1] = player.split(2 * width, height, width, height); 
		
		ivo_left = new BufferedImage[2];
		ivo_left[0] = mal.split(0, height, width, height);
		ivo_left[1] = mal.split(2 * width, height, width, height); 

		player_right = new BufferedImage[2];
		player_right[0] = player.split(0, 2 * height, width, height);
		player_right[1] = player.split(2 * width, 2 * height, width, height);
		
		ivo_right = new BufferedImage[2];
		ivo_right[0] = mal.split(0, 2 * height, width, height);
		ivo_right[1] = mal.split(2 * width, 2 * height, width, height);
		
		watera = new BufferedImage[32];
		watera[0] = aWater.split(0, 0, width, height);
		watera[1] = aWater.split(0, height, width, height);
		watera[2] = aWater.split(0, 2*height, width, height);
		watera[3] = aWater.split(0, 3*height, width, height);
		watera[4] = aWater.split(0, 4*height, width, height);
		watera[5] = aWater.split(0, 5*height, width, height);
		watera[6] = aWater.split(0, 6*height, width, height);
		watera[7] = aWater.split(0, 7*height, width, height);
		watera[8] = aWater.split(0, 8*height, width, height);
		watera[9] = aWater.split(0, 9*height, width, height);
		watera[10] = aWater.split(0, 10*height, width, height);
		watera[11] = aWater.split(0,11*height, width, height);
		watera[12] = aWater.split(0, 12*height, width, height);
		watera[13] = aWater.split(0, 13*height, width, height);
		watera[14] = aWater.split(0, 14*height, width, height);
		watera[15] = aWater.split(0, 15*height, width, height);
		watera[16] = aWater.split(0, 16*height, width, height);
		watera[17] = aWater.split(0, 17*height, width, height);
		watera[18] = aWater.split(0, 18*height, width, height);
		watera[19] = aWater.split(0, 19*height, width, height);
		watera[20] = aWater.split(0, 20*height, width, height);
		watera[21] = aWater.split(0, 21*height, width, height);
		watera[22] = aWater.split(0, 22*height, width, height);
		watera[23] = aWater.split(0, 23*height, width, height);
		watera[24] = aWater.split(0, 24*height, width, height);
		watera[25] = aWater.split(0, 25*height, width, height);
		watera[26] = aWater.split(0, 26*height, width, height);
		watera[27] = aWater.split(0, 27*height, width, height);
		watera[28] = aWater.split(0, 28*height, width, height);
		watera[29] = aWater.split(0, 29*height, width, height);
		watera[30] = aWater.split(0, 30*height, width, height);
		watera[31] = aWater.split(0, 31*height, width, height);

		/* Items */
		
		trivel = items.split(0, 0, width, height);
		money = items.split(0, height, width, height);
		triviartefakt = items.split(0, 2* height, width, height);
		dsword = items.split(width, 0, width, height);
		msword = items.split(width, height, width, height);
		tsword = items.split(width, 2 * height, width, height);
		jibbet = items.split(2* width, 0, width, height);
		monster = items.split(2* width, height, width, height);
		

		/* Entities */

		tree = terrain.split(2 * width, 0, width, 2 * height);
		tree2 = terrain.split(0, 4*height, width, 2*height);
		ganja = terrain.split(2*width, 2*height, width, 2*height);
		sGanja = terrain.split(width, 2*height, width, 2*height);
		rGanja = terrain.split(0, 2*height, width, 2*height);
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
		
		// Ivo Malenica
		
		iMDown = mal.split(width, 0, width, height);
		iMLeft = mal.split(width, 1 * height, width, height);
		iMRight = mal.split(width, 2 * height, width, height);
		iMUp = mal.split(width, 3 * height, width, height);

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
