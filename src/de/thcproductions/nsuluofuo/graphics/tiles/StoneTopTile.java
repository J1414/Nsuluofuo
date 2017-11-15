package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class StoneTopTile extends Tile{

	public StoneTopTile(int id) {
		super(Assets.stoneBright, id,32,32);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
