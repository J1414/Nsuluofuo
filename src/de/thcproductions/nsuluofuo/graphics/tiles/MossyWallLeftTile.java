package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class MossyWallLeftTile extends Tile{

	public MossyWallLeftTile(int id) {
		super(Assets.mossyWallLeft, id);
		
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
