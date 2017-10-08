package de.thcproductions.nsuluofuo.statics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import de.thcproductions.nsuluofuo.creatures.Creature;
import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.main.Handler;

public class Tree extends StaticEntity{
	
	private float x, y;
	private Random random = new Random();
	private BufferedImage[] textures = new BufferedImage[2];
	private BufferedImage texture;

	public Tree(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, 2* Creature.DEFAULT_CREATURE_HEIGHT);
		this.x = x * 32;
		this.y = y * 32;
		this.textures[0] = Assets.tree;
		this.textures[1] = Assets.tree2;
		texture = textures[random.nextInt(2)];
		bounds.x = 12;
		bounds.y = 50;
		bounds.width = 6;
		bounds.height = 6;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(texture, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), null);
		
	}

}
