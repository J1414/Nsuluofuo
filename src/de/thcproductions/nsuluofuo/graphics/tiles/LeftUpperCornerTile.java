package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class LeftUpperCornerTile extends Tile{

	public LeftUpperCornerTile(int id) {
		super(Assets.leftUpperCorner, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSolid(){
		return true;
	}
}
