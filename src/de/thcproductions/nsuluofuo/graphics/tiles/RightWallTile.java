package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class RightWallTile extends Tile {

	public RightWallTile(int id) {
		super(Assets.rightWall, id);

	}

	@Override
	public boolean isSolid() {
		return true;
	}
}
