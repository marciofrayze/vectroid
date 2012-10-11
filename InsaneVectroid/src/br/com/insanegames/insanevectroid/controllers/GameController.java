package br.com.insanegames.insanevectroid.controllers;

import java.util.ArrayList;

import br.com.insanegames.insanevectroid.gameobjects.GameObject;
import br.com.insanegames.insanevectroid.util.GameScreen;
import android.app.Activity;
import android.graphics.Canvas;
import android.util.DisplayMetrics;

/**
 * Esta classe eh responsavel por controlar o jogo em geral. A logica do jogo nao deve estar nela, ela apenas deve delegar aos responsaveis o que fazer.
 * Esta eh uma classe abstrata contendo apenas o basico geral. Deve ser extendida e adptada para cada jogo.
 * @author Marcio Frayze David
 *
 */
public abstract class GameController {
		
	/** Esta lista contem todos os objetos do jogo.	 */
	protected ArrayList<GameObject> gameObjects;
	/** O GameController delega ao GameScreen a responsabilidade de desenhar os objetos na tela */
	protected GameScreen gameScreen;
	
	public GameController(Activity activity) {
		this.gameObjects = new ArrayList<GameObject>();
		DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
		this.gameScreen = new GameScreen(metrics.widthPixels, metrics.heightPixels);
	}
	
	/**
	 * Use este metodo para adicionar novos objetos ao jogo. Automaticamente eles serao renderizados, atualizados (chamada ao metodo think()), etc.
	 * @param moreGameObjects
	 */
	public void addGameObject(GameObject... moreGameObjects) {
		for (GameObject gameObject : moreGameObjects) {
			gameObjects.add(gameObject);
		}
	}
	
	/**
	 * Toda vez que um ciclo do jogo for executado este metodo deve ser chamado para que os objetos sejam atualizados.
	 */
	public void updateWorld() {
		this.makeObjectsThink();
		this.checkCollisions();		
	}
	
	private void checkCollisions() {
		for (GameObject gameObject : gameObjects) {
			for (GameObject anotherGameObject : gameObjects) {
				if (isCollidable(gameObject, anotherGameObject)) {
					gameObject.whenCollidingWith(anotherGameObject);
				}
			}
		}		
	}

	private boolean isCollidable(GameObject gameObject, GameObject anotherGameObject) {
		return (gameObject != anotherGameObject && gameObject.isCollidable() && anotherGameObject.isCollidable() && gameObject.isCollidingWith(anotherGameObject));
	}
	
	private void makeObjectsThink() {
		for (GameObject gameObject : gameObjects) {
			gameObject.think();
		}		
	}

	/**
	 * Desenha os objetos do jogo em um canvas
	 * @param canvas
	 */
	public void drawWorld(Canvas canvas) {
		for (GameObject gameObject : gameObjects) {
			gameScreen.drawGameObject(gameObject, canvas);
		}			
	}
		
	/**
	 * Injecta a classe GameScreen. Delegamos a ela a responsabilidade de desenharmos os objetos na tela.
	 * @param gameScreen
	 */
	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;		
	}
	
	public ArrayList<GameObject> getGameObjects() {
		return this.gameObjects;
	}

}
