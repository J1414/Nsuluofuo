package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class MiddleWallTile extends Tile{

	public MiddleWallTile(int id) {
		super(Assets.middleWall, id);
		
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
