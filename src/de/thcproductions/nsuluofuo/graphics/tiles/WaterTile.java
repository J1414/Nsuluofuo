package de.thcproductions.nsuluofuo.graphics.tiles;

import de.thcproductions.nsuluofuo.graphics.Assets;

public class WaterTile extends Tile {
	
	

	public WaterTile(int id) {
		super(Assets.watera[0], id,32,32);
		
	}
	
	public boolean isSolid() {
		return true;
	}

}
