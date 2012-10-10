package br.com.insanegames.insanevectroid.controllers;

import br.com.insanegames.insanevectroid.util.ScreenSize;
import android.view.MotionEvent;

/**
 * Classe responsavel por controlar os inputs do usuario (touch)
 * Esta classe contem apenas a estrutura basica e deve ser extendida para atender as necessidades de cada jogo.
 * @author Marcio Frayze David
 */
public abstract class InputController {
	
	/**
	 * Ao receber um evento de touch, interpreta ele e repassa para o gameController tomas as devidas acoes
	 */
	protected GameController gameController;
	protected ScreenSize screenSize;
	
	public InputController(GameController gameController, ScreenSize screenSize) {
		this.gameController = gameController;
		this.screenSize = screenSize;
	}
	
	public abstract void onMotionEvent(MotionEvent motionEvent);

}
