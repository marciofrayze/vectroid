package br.com.insanegames.insanevectroid;

public class RectSinGameObject extends RectGameObject {

	private float sinAngle;
	
	public RectSinGameObject(float x, float y, float width, float height,
			float speed, int color) {
		super(x, y, width, height, speed, color);
		sinAngle=(int) (Math.random() * 360);

	}

	public void think() {
		this.position.setX(this.position.getX() + ( (float) 1 * (float)Math.sin(this.sinAngle)));
		
		this.sinAngle = this.sinAngle + 0.01f;
		if (this.sinAngle > 360) {
			this.sinAngle = 0;
		}
		this.position.setY(this.position.getY()+this.speed);
		if (this.position.getY() > 1000) {
			this.position.setY(-this.height);
		}
	}
}
