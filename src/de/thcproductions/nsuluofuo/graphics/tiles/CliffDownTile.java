package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class CliffDownTile extends Tile{

	public CliffDownTile(int id) {
		super(Assets.cliffDown, id);
		
	}
	
	@Override 
	public boolean isSolid(){
		return true;
	}

}
