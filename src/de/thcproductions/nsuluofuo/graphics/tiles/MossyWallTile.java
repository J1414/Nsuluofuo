package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class MossyWallTile extends Tile{

	public MossyWallTile(int id) {
		super(Assets.mossyWall, id);
		
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
