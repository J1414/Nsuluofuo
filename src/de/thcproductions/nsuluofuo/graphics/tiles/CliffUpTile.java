package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class CliffUpTile extends Tile{

	public CliffUpTile(int id) {
		super(Assets.cliffUp, id,32,32);
		
	}
	
	@Override 
	public boolean isSolid(){
		return true;
	}

}
