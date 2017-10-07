package de.thcproductions.nsuluofuo.statics;

import java.awt.Graphics;

import de.thcproductions.nsuluofuo.creatures.Creature;
import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.main.Handler;

public class Ganja extends StaticEntity{
	
	private float x, y;
	

	public Ganja(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, 2* Creature.DEFAULT_CREATURE_HEIGHT);
		this.x = x * 32;
		this.y = y * 32;
		
		bounds.x = 15;
		bounds.y = 52;
		bounds.width = 2;
		bounds.height = 2;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.ganja, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), null);
		
	}

}
