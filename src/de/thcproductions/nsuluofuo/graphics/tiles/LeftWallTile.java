package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class LeftWallTile extends Tile {

	public LeftWallTile(int id) {
		super(Assets.leftWall, id,32,32);

	}

	@Override
	public boolean isSolid() {
		return true;
	}
}
