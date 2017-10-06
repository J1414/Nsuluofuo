package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class CliffRightTile extends Tile{

	public CliffRightTile(int id) {
		super(Assets.cliffRight, id);
		
	}
	
	@Override 
	public boolean isSolid(){
		return true;
	}

}
