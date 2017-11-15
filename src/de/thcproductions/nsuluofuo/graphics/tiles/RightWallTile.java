package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class RightWallTile extends Tile {

	public RightWallTile(int id) {
		super(Assets.rightWall, id,32,32);

	}

	@Override
	public boolean isSolid() {
		return true;
	}
}
