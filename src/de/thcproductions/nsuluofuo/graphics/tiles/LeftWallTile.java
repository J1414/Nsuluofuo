package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class LeftWallTile extends Tile {

	public LeftWallTile(int id) {
		super(Assets.leftWall, id);

	}

	@Override
	public boolean isSolid() {
		return true;
	}
}
