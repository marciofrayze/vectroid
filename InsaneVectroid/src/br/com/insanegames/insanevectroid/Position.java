package br.com.insanegames.insanevectroid;

public class Position {
	
	private float x;
	private float y;
	
	public Position() {
		this.set(x,y);
	}
	
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Position(float x, float y) {
		this.set(x,y);
	}
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
}
