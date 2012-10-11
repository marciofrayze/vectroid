package samplegame;

import android.util.FloatMath;
import br.com.insanegames.insanevectroid.gameobjects.GameObject;
import br.com.insanegames.insanevectroid.gameobjects.RectGameObject;

public class RectSinGameObject extends RectGameObject {

	private float sinAngle;
	
	public RectSinGameObject(float x, float y, float width, float height, float speed, int color) {
		super(x, y, width, height, speed, color);
		sinAngle=(int) (Math.random() * 360);
	}

	public void think() {
		// move objeto com movimento de uma onda
		this.position.setX(this.position.getX() + ( (float) 1 * (float)FloatMath.sin(this.sinAngle)));
		
		this.sinAngle = this.sinAngle + 0.01f;
		if (this.sinAngle > 360) {
			this.sinAngle = 0;
		}
		this.position.setY(this.position.getY()+this.speed);
		// se tiver saindo da tela, volta para cima
		if (this.position.getY() > 768+height) {
			this.position.setY(-this.height);
		}
	}

	@Override
	public void whenCollidingWith(GameObject anotherGameObject) {
		// TODO
	}
}
