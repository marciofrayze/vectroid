package br.com.insanegames.insanevectroid;

public abstract class GameObject {
	
	protected Position position;
	protected float width;
	protected float height;
	protected int color;

	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	
	public boolean isCollidingWith(GameObject gameObject) {
		return false;
	}
	
	public abstract Line[] getLines();
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return this.color;
	}
	
	public abstract void think();

}
