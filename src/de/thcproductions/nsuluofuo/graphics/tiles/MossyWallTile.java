package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class MossyWallTile extends Tile{

	public MossyWallTile(int id) {
		super(Assets.mossyWall, id,32,32);
		
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
