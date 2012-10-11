package br.com.insanegames.insanevectroid.gameobjects;

import br.com.insanegames.insanevectroid.util.Line;
import br.com.insanegames.insanevectroid.util.Position;

public abstract class GameObject {
	
	protected Position position;
	protected float width;
	protected float height;
	protected int color;
	protected boolean isCollidable;

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
	
	public boolean isCollidingWith(GameObject anotherGameObject) {
		return ( Math.abs(this.getPosition().getX() - anotherGameObject.getPosition().getX()) <= this.getWidth() + anotherGameObject.getWidth() ||
				Math.abs(this.getPosition().getY() - anotherGameObject.getPosition().getY()) <= this.getHeight() + anotherGameObject.getHeight());	
	}
	
	public abstract Line[] getLines();
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return this.color;
	}
	
	public abstract void think();
	
	// voce pode usar este metodo para diferenciar uma colecao de objetos
	// TODO: mudar para um enum?
	public String type() {
		return "nobody";
	}

	public void move(float x, float y) {
		this.setPosition(new Position(this.getPosition().getX() + x, this.getPosition().getY() + y));		
	}
	
	/**
	 * Metodo chamado quando dois objetos colidem
	 * @param anotherGameObject
	 */
	public abstract void whenCollidingWith(GameObject anotherGameObject);
	
	public void enableCollisionDetection() {
		this.isCollidable = true;
	}
	
	public void disableCollisionDetection() {
		this.isCollidable = false;
	}		

	public boolean isCollidable() {
		return this.isCollidable; 
	}
}