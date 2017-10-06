package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class TreeTile extends Tile {

	public TreeTile(int id) {
		super(Assets.tree, id);
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
