package de.thcproductions.nsuluofuo.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import de.thcproductions.nsuluofuo.main.Handler;

public class KeyManager implements KeyListener {

	private boolean[] keys, justPressed, cantPress;
	private boolean up, down, left, right, space;
	private boolean w, a, s, d ,f;
	private Handler handler;
	
	public boolean isW() {
		return w;
	}

	public void setW(boolean w) {
		this.w = w;
	}
	
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isSpace() {
		return space;
	}

	public void setSpace(boolean space) {
		this.space = space;
	}
	
	public boolean isA() {
		return a;
	}

	public boolean isS() {
		return s;
	}

	public boolean isD() {
		return d;
	}

	public boolean isF() {
		return f;
	}

	public void setA(boolean a) {
		this.a = a;
	}

	public void setS(boolean s) {
		this.s = s;
	}

	public void setD(boolean d) {
		this.d = d;
	}

	public void setF(boolean f) {
		this.f = f;
	}

	public KeyManager() {
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}
	
	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length){
			return false;
		}
		return justPressed[keyCode];
	}

	public void update() {
		for(int i = 0; i < keys.length; i++){
			if(cantPress[i] && !keys[i]){
				cantPress[i] =  false;
			}else if(justPressed[i]){
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i]){
				justPressed[i] = true;
			}
		}
		
		
		
		setUp(keys[KeyEvent.VK_UP]);
		setDown(keys[KeyEvent.VK_DOWN]);
		setLeft(keys[KeyEvent.VK_LEFT]);
		setRight(keys[KeyEvent.VK_RIGHT]);
		setSpace(keys[KeyEvent.VK_SPACE]);
		
		setA(keys[KeyEvent.VK_A]);
		setS(keys[KeyEvent.VK_S]);
		setD(keys[KeyEvent.VK_D]);
		setF(keys[KeyEvent.VK_S]);
		setW(keys[KeyEvent.VK_W]);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length){
			return;
		}
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length){
			return;
		}
		keys[e.getKeyCode()] = false;
		keys[5] = true;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
