package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class CliffDownTile extends Tile{

	public CliffDownTile(int id) {
		super(Assets.cliffDown, id,32,32);
		bounds.x = 30;
		bounds.y = 0;
		bounds.width = 32;
		bounds.height = 2;
	}
	
	@Override 
	public boolean isSolid(){
		return true;
	}

}
