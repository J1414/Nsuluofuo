package de.thcproductions.nsuluofuo.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;
	public static BufferedImage house, grass, highGrass, tree, water, bridge, path, stone, stoneBright, gate, playerDown, playerUp, playerLeft,
			playerRight, atkDown, atkUp, atkLeft, atkRight, mNpcUp, mNpcDown, mNpcLeft, mNpcRight, fNpcUp, fNpcDown,
			fNpcLeft, fNpcRight, skullReaper, skullReaperLeft, skullReaperRight, skullReaperUp, slime, largeRock, rock, rocks, wood, money, dsword, asword, middleWall,
			mossyWall, mossyWallLeft, mossyWallRight, leftWall, rightWall, cliffDown, cliffUp, cliffLeft, cliffRight,
			leftUpperCorner, leftBottomCorner, rightUpperCorner, rightBottomCorner;
	public static BufferedImage[] start_btn, close_button, player_down, player_up, player_left, player_right;
	public static Font head, text, smallText;
	public static BufferedImage background;
	public static BufferedImage gameO;
	public static BufferedImage ivo;

	public static void initialize() {

		head = FontLoader.loadFont("res/fonts/saoFont.ttf", 128);
		text = FontLoader.loadFont("res/fonts/saoFont.ttf", 64);
		smallText = FontLoader.loadFont("res/fonts/saoFont.ttf", 24);
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Spritesheet.png"));
		SpriteSheet gameOver = new SpriteSheet(ImageLoader.loadImage("/textures/GameOver.png"));
		SpriteSheet uli = new SpriteSheet(ImageLoader.loadImage("/textures/uli.jpg"));

		ivo = uli.split(0, 0, 640, 480);
		
		/* GUI */
		start_btn = new BufferedImage[2];
		start_btn[0] = sheet.split(12 * width, 0, 4 * width, 2 * height);
		start_btn[1] = sheet.split(12 * width, 2 * height, 4 * width, 2 * height);
		
		close_button = new BufferedImage[2];
		close_button[0] = sheet.split(12* width, 4* height, 4* width , 2* height);
		close_button[1] = sheet.split(12* width,  6* height, 4* width, 2* height);

		/* Animations */
		player_down = new BufferedImage[2];
		player_down[0] = sheet.split(0, 2 * height, width, height);
		player_down[1] = sheet.split(2 * width, 2 * height, width, height);

		player_up = new BufferedImage[2];
		player_up[0] = sheet.split(0, 5 * height, width, height);
		player_up[1] = sheet.split(2 * width, 5 * height, width, height);

		player_left = new BufferedImage[2];
		player_left[0] = sheet.split(0, 3 * height, width, height);
		player_left[1] = sheet.split(2 * width, 3 * height, width, height);

		player_right = new BufferedImage[2];
		player_right[0] = sheet.split(0, 4 * height, width, height);
		player_right[1] = sheet.split(2 * width, 4 * height, width, height);

		/* Fullscreen */
		gameO = gameOver.split(0, 0, 640, 480);

		/* Items */
		rocks = sheet.split(3 * width, 4 * height, width, height);
		wood = sheet.split(3 * width, 5 * height, width, height);
		money = sheet.split(3 * width, 6 * height, width, height);
		dsword = sheet.split(4 * width, 5 * height, width, height);
		asword = sheet.split(4 * width, 6 * height, width, height);

		/* Entities */
		
		//Skull Reaper
		skullReaper = sheet.split(0, 12 * height, 3 * width, 4 * height);
		skullReaperLeft = sheet.split(3*width, 12*height, 4 * width, 3*height);
		skullReaperRight = sheet.split(7*width, 12*height, 4*width, 3*height);
		skullReaperUp = sheet.split(11*width, 12*height, 3*width, 4*height);
		slime = sheet.split(3 * width, 15 * height, width, height);
		tree = sheet.split(2 * width, 0, width, 2 * height);
		rock = sheet.split(3 * width, 0, width, height);
		largeRock = sheet.split(3 * width, 2 * height, width, 2 * height);

		/* Player */
		playerDown = sheet.split(width, 2 * height, width, height);
		playerLeft = sheet.split(width, 3 * height, width, height);
		playerRight = sheet.split(width, 4 * height, width, height);
		playerUp = sheet.split(width, 5 * height, width, height);

		/* NPC's */

		// female
		fNpcDown = sheet.split(5 * width, 5 * height, width, height);
		fNpcLeft = sheet.split(5 * width, 6 * height, width, height);
		fNpcRight = sheet.split(5 * width, 7 * height, width, height);
		fNpcUp = sheet.split(5 * width, 8 * height, width, height);

		// male
		mNpcDown = sheet.split(6 * width, 5 * height, width, height);
		mNpcLeft = sheet.split(6 * width, 6 * height, width, height);
		mNpcRight = sheet.split(6 * width, 7 * height, width, height);
		mNpcUp = sheet.split(6 * width, 8 * height, width, height);
		
		/* Buildings */
		
		house = sheet.split(12*width, 4*height, 4*width, 6*height);

		/* Attack */

		atkDown = sheet.split(width, 6 * height, width, height);
		atkLeft = sheet.split(width, 3 * height, width, height);
		atkRight = sheet.split(width, 8 * height, width, height);
		atkUp = sheet.split(width, 9 * height, width, height);

		/* Tiles */
		grass = sheet.split(0, 0, width, height);
		highGrass = sheet.split(width, 0, width, height);
		water = sheet.split(0, height, width, height);
		bridge = sheet.split(3 * width, 9 * height, width, height);
		path = sheet.split(width, height, width, height);
		stone = sheet.split(3 * width, height, width, height);
		stoneBright = sheet.split(7*width, height, width, height);
		gate = sheet.split(7*width, 2*height, width, height);
		middleWall = sheet.split(6 * width, 0, width, height);
		cliffDown = sheet.split(6 * width, 2 * height, width, height);
		cliffUp = sheet.split(6 * width, height, width, height);
		cliffLeft = sheet.split(6 * width, 3 * height, width, height);
		cliffRight = sheet.split(6 * width, 4 * height, width, height);
		leftUpperCorner = sheet.split(4 * width, 0, width, height);
		leftBottomCorner = sheet.split(4 * width, height, width, height);
		rightUpperCorner = sheet.split(5 * width, 0, width, height);
		rightBottomCorner = sheet.split(5 * width, height, width, height);
		mossyWall = sheet.split(7 * width, 0, width, height);
		mossyWallLeft = sheet.split(4 * width, 4 * height, width, height);
		mossyWallRight = sheet.split(5 * width, 4 * height, width, height);
		leftWall = sheet.split(4 * width, 2 * height, width, height);
		rightWall = sheet.split(5 * width, 2 * height, width, height);

	}

}
