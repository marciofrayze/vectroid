package samplegame;

import br.com.insanegames.insanevectroid.gameobjects.RectGameObject;


public class PlayerGameObject extends RectGameObject {

	private boolean isMovingLeft;
	private boolean isMovingRight;
	
	public PlayerGameObject(float x, float y, float width, float height, float speed, int color) {
		super(x, y, width, height, speed, color);
		this.resetMovingVars();
	}

	public void think() {
		if (isMovingLeft) {
			this.move(-this.speed, 0);
		} else if (isMovingRight) {
			this.move(this.speed, 0);
		}
		
		this.resetMovingVars();
	}
	
	private void resetMovingVars() {
		isMovingLeft = false;
		isMovingLeft = false;		
	}

	public String type() {
		return "player";
	}

	public void moveLeft() {
		this.isMovingLeft = true;
	}
	public void moveRight() {
		this.isMovingRight = true;		
	}

}
