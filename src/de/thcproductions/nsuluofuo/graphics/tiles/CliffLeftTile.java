package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class CliffLeftTile extends Tile{

	public CliffLeftTile(int id) {
		super(Assets.cliffLeft, id);
		
	}
	
	@Override 
	public boolean isSolid(){
		return true;
	}

}
