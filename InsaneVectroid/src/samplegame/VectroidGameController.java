package samplegame;

import android.app.Activity;
import br.com.insanegames.insanevectroid.controllers.GameController;
import br.com.insanegames.insanevectroid.gameobjects.GameObject;

public class VectroidGameController extends GameController {

	public VectroidGameController(Activity activity) {
		super(activity);		
	}

	public void movePlayerLeft() {	
		// TODO otimizar este codigo!
		for (GameObject gameObject : gameObjects) {
			if (gameObject.type().equals("player")) {
				((PlayerGameObject) gameObject).moveLeft();
			}
		}	
	}
	
	public void movePlayerRight() {		
		// TODO otimizar este codigo!
		for (GameObject gameObject : gameObjects) {
			if (gameObject.type().equals("player")) {
				((PlayerGameObject) gameObject).moveRight();
			}
		}	
	}

}
