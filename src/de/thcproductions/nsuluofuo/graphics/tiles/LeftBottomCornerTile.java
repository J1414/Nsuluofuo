package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class LeftBottomCornerTile extends Tile{

	public LeftBottomCornerTile(int id) {
		super(Assets.leftBottomCorner, id,32,32);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSolid(){
		return true;
	}
}

