package samplegame;

import android.view.MotionEvent;
import br.com.insanegames.insanevectroid.controllers.GameController;
import br.com.insanegames.insanevectroid.controllers.InputController;
import br.com.insanegames.insanevectroid.util.ScreenSize;

public class VectroidInputController extends InputController {

	public VectroidInputController(GameController gameController, ScreenSize screenSize) {
		super(gameController, screenSize);
	}

	@Override
	public void onMotionEvent(MotionEvent motionEvent) {
		if (motionEvent.getX() < screenSize.getRealWidth() / 2) {
			// clicando na parte da esquerda da tela... move jogador para esquerda!
			// TODO: Tentar retirar esse casting de alguma forma.
			((VectroidGameController)gameController).movePlayerLeft();
		} else {
			// clicando na parte da direita da tela... move jogador para direita!
			((VectroidGameController)gameController).movePlayerRight();
		}
	}

}
