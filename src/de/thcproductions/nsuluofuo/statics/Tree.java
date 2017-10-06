package de.thcproductions.nsuluofuo.statics;

import java.awt.Graphics;

import de.thcproductions.nsuluofuo.creatures.Creature;
import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.main.Handler;

public class Tree extends StaticEntity{
	
	private float x, y;
	

	public Tree(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, 2* Creature.DEFAULT_CREATURE_HEIGHT);
		this.x = x;
		this.y = y;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int)x, (int)y, null);
		
	}

}
