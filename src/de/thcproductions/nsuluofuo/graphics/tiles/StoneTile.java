package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class StoneTile extends Tile{

	public StoneTile(int id) {
		super(Assets.stone, id,32,32);
		
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
