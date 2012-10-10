package br.com.insanegames.insanevectroid.controllers;

import br.com.insanegames.insanevectroid.util.ScreenSize;
import android.view.MotionEvent;

/**
 * Classe responsavel por controlar os inputs do usuario (touch)
 * @author Marcio Frayze David
 */
public class InputController {
	
	/**
	 * Ao receber um evento de touch, interpreta ele e repassa para o gameController tomas as devidas acoes
	 */
	private GameController gameController;
	private ScreenSize screenSize;
	
	public InputController(GameController gameController, ScreenSize screenSize) {
		this.gameController = gameController;
		this.screenSize = screenSize;
	}
	
	public void onMotionEvent(MotionEvent motionEvent) {
		System.out.println("Entrei no onMotionEvent do InputController");
		if (motionEvent.getX() < screenSize.getRealWidth() / 2) {
			// clicando na parte da esquerda da tela... move jogador para esquerda!
			// TODO: os metodos movePlayerLeft e movePlayerRight nao fazem parte do escopo da engine e sim do jogo
			// talvez pudesse criar uma estrutura mais generica e extender ela para ficar mais facil re-utilizacao
			gameController.movePlayerLeft();
		} else {
			// clicando na parte da direita da tela... move jogador para direita!
			gameController.movePlayerRight();

		}
	}

}
