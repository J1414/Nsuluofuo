package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class RightBottomCornerTile extends Tile{

	public RightBottomCornerTile(int id) {
		super(Assets.rightBottomCorner, id,32,32);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSolid(){
		return true;
	}
}

