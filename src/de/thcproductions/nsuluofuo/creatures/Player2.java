package de.thcproductions.nsuluofuo.creatures;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import de.thcproductions.nsuluofuo.graphics.Animation;
import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.main.Handler;
import de.thcproductions.nsuluofuo.multiplayer.SimpleDualPlayer;

public class Player2 extends Creature {
	private BufferedImage currentPosition = Assets.playerDown;
	private Animation animDown, animUp, animLeft, animRight;

	public Player2(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		animDown = new Animation(animDown.DEFAULT_SPEED, Assets.player_down);
		animUp = new Animation(animUp.DEFAULT_SPEED, Assets.player_up);
		animLeft = new Animation(animLeft.DEFAULT_SPEED, Assets.player_left);
		animRight = new Animation(animRight.DEFAULT_SPEED, Assets.player_right);

		//collisionbox vorübergehend auf null gemacht
		
//		bounds.x = 8;
//		bounds.y = 16;
//		bounds.width = 16;
//		bounds.height = 16;
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 0;
		bounds.height = 0;

	}

	@Override
	public void update() {

		animDown.update();
		animUp.update();
		animLeft.update();
		animRight.update();

		//getInput();
		move();
		
		//Positionsdaten von Multiplayerklassen holen
		float remoteX = ((float)SimpleDualPlayer.getPlayerR().getPositionX());
		float remoteY = ((float)SimpleDualPlayer.getPlayerR().getPositionY());
		
		//System.out.println("x ist: " + getX() + " x soll: " + remoteX + " differenz: " + Math.abs(getX() - remoteX) + " mehr als default speed: " + (boolean)(Math.abs(getY() - remoteY) > DEFAULT_SPEED));
		//System.out.println("y ist: " + getY() + " y soll: " + remoteY + " differenz " + Math.abs(getY() - remoteY) + " mehr als default speed: " + (boolean)(Math.abs(getY() - remoteY) > DEFAULT_SPEED));
        
		if(Math.abs(getY() - remoteY) > DEFAULT_SPEED*2){
			
			if (getY() > remoteY) {
				setyMove(- getSpeed()*2);
				currentPosition = animUp.getCurrentFrame();
			}
			if (getY() < remoteY) {
				setyMove(+ getSpeed()*2);
				currentPosition = animDown.getCurrentFrame();
			}
		}
		else{
			setY(remoteY);
		}
		if(Math.abs(getX() - remoteX) > DEFAULT_SPEED*2){
			
			if (getX() > remoteX) {
				setxMove(- getSpeed()*2);
				currentPosition = animLeft.getCurrentFrame();
			}
			if (getX() < remoteX) {
				setxMove(+ getSpeed()*2);
				currentPosition = animRight.getCurrentFrame();
			}
		}
		else{
			setX(remoteX);
		}
		

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (getX() - handler.getGameCamera().getxOffset()),
				(int) (getY() - handler.getGameCamera().getyOffset()), getWidth(), getHeight(), null);

	}

	private BufferedImage getCurrentAnimationFrame() {
		if (handler.getKeyManager().isA()) {
			currentPosition = animLeft.getCurrentFrame();
		} else if (handler.getKeyManager().isD()) {
			currentPosition = animRight.getCurrentFrame();
		} else if (handler.getKeyManager().isW()) {
			currentPosition = animUp.getCurrentFrame();
		} else if (handler.getKeyManager().isS()) {
			currentPosition = animDown.getCurrentFrame();
		} else if (currentPosition == null) {

			currentPosition = Assets.playerDown;
		}

		return currentPosition;

	}

	private void getInput() {

		setxMove(0);
		setyMove(0);

		if (handler.getKeyManager().isW()) {
			setyMove(getyMove() - getSpeed());
		}
		if (handler.getKeyManager().isS()) {
			setyMove(getyMove() + getSpeed());
		}
		if (handler.getKeyManager().isA()) {
			setxMove(getxMove() - getSpeed());
		}
		if (handler.getKeyManager().isD()) {
			setxMove(getxMove() + getSpeed());
		}

		if (handler.getKeyManager().isSpace()) {
			setSpeed(DEFAULT_SPEED * 2);
			animDown.setSpeed(animDown.DEFAULT_SPEED / 2);
			animUp.setSpeed(animUp.DEFAULT_SPEED / 2);
			animLeft.setSpeed(animLeft.DEFAULT_SPEED / 2);
			animRight.setSpeed(animRight.DEFAULT_SPEED / 2);
		} else {
			setSpeed(DEFAULT_SPEED);
			animDown.setSpeed(animDown.DEFAULT_SPEED);
			animUp.setSpeed(animUp.DEFAULT_SPEED);
			animLeft.setSpeed(animLeft.DEFAULT_SPEED);
			animRight.setSpeed(animRight.DEFAULT_SPEED);
		}

	}

}
