package de.thcproductions.nsuluofuo.multiplayer;

// Felix @ THC Productions 5.10.2017
public class MpCharacter {
	private double positionX;
	private double positionY;
	private int blickrichtung;

	public MpCharacter(double ppositionX, double ppositionY, int pblickrichting){
		
		positionX = ppositionX;
		positionY = ppositionY;
		blickrichtung = pblickrichting;
		
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double ppositionX) {
		this.positionX = ppositionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double ppositionY) {
		this.positionY = ppositionY;
	}

	public int getBlickrichtung() {
		return blickrichtung;
	}

	public void setBlickrichtung(int pblickrichtung) {
		this.blickrichtung = pblickrichtung;
	}
	
	
}
