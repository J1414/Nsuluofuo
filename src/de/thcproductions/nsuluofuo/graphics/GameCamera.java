package de.thcproductions.nsuluofuo.graphics;

import de.thcproductions.nsuluofuo.entities.Entity;
import de.thcproductions.nsuluofuo.graphics.tiles.Tile;
import de.thcproductions.nsuluofuo.main.Handler;

public class GameCamera {

	private float xOffset;
	private float yOffset;
	private Handler handler;

	public void move(float xAmt, float yAmt) {
		setxOffset(getxOffset() + xAmt);
		setyOffset(getyOffset() + yAmt);
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

	public void centerOnEntity(Entity e) {
		setxOffset(e.getX() - handler.getWidth() / 2 + e.getWidth() / 2);
		setyOffset(e.getY() - handler.getHeight() / 2 + e.getHeight() / 2);
		checkBlankSpace();
	}
	
	public void checkBlankSpace(){
		if(getxOffset() < 0){
			setxOffset(0);
		}else if(getxOffset() > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
			setxOffset(handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth());
		}
		if(getyOffset() < 0){
			setyOffset(0);
		}else if(getyOffset() > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()){
			setyOffset(handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight());
		}
	}

	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;

	}

}
