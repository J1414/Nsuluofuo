package de.thcproductions.nsuluofuo.statics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import de.thcproductions.nsuluofuo.creatures.Creature;
import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.main.Handler;

public class Ganja extends StaticEntity{
	
	private float x, y;
	
	private Random random = new Random();
	private BufferedImage[] textures = new BufferedImage[3];
	private BufferedImage texture;

	public Ganja(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, 2* Creature.DEFAULT_CREATURE_HEIGHT);
		this.x = x * 32;
		this.y = y * 32;
		
		bounds.x = 15;
		bounds.y = 52;
		bounds.width = 2;
		bounds.height = 2;
		this.textures[0] = Assets.ganja;
		this.textures[1] = Assets.sGanja;
		this.textures[2] = Assets.rGanja;
		texture = textures[random.nextInt(3)];
		
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
