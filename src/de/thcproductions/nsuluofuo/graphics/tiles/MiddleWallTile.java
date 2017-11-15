package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class MiddleWallTile extends Tile{

	public MiddleWallTile(int id) {
		super(Assets.middleWall, id,32,32);
		
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
