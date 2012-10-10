package samplegame;

import android.app.Activity;
import br.com.insanegames.insanevectroid.controllers.GameController;

public class VectroidGameController extends GameController {

	private PlayerGameObject player;
	
	public VectroidGameController(Activity activity) {
		super(activity);		
	}

	public void movePlayerLeft() {	
		player.moveLeft();
	}
	
	public void movePlayerRight() {		
		player.moveRight();	}
	
	public PlayerGameObject getPlayer() {
		return player;
	}

	public void setPlayer(PlayerGameObject player) {
		this.player = player;
		// se jogador ainda nao tiver na lista de objetos, adicione ele
		if (!this.gameObjects.contains(player)) {
			gameObjects.add(player);
		}		
	}


}
