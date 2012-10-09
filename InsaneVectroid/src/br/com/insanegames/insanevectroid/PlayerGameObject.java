package br.com.insanegames.insanevectroid;

public class PlayerGameObject extends RectGameObject {

	public PlayerGameObject(float x, float y, float width, float height, float speed, int color) {
		super(x, y, width, height, speed, color);
	}

	public void think() {
		// nao faça nada
	}
	
	public String type() {
		return "player";
	}
}
