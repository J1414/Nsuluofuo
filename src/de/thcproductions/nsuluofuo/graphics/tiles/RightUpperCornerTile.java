package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class RightUpperCornerTile extends Tile{

	public RightUpperCornerTile(int id) {
		super(Assets.rightUpperCorner, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}

