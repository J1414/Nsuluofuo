package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class MossyWallRightTile extends Tile{

	public MossyWallRightTile(int id) {
		super(Assets.mossyWallRight, id,32,32);
		
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
