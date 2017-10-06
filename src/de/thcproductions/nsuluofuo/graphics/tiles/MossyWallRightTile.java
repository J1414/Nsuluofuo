package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class MossyWallRightTile extends Tile{

	public MossyWallRightTile(int id) {
		super(Assets.mossyWallRight, id);
		
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
