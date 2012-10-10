package br.com.insanegames.insanevectroid.controllers;

import java.util.ArrayList;

import br.com.insanegames.insanevectroid.gameobjects.GameObject;
import br.com.insanegames.insanevectroid.util.GameScreen;
import br.com.insanegames.insanevectroid.util.ScreenSize;
import android.graphics.Canvas;

/**
 * Esta classe eh responsavel por controlar o jogo em geral. A logica do jogo nao deve estar nela, ela apenas deve delegar aos responsaveis o que fazer.
 * @author Marcio Frayze David
 *
 */
public class GameController {
		
	/** Esta lista contem todos os objetos do jogo.	 */
	private ArrayList<GameObject> gameObjects;
	/** O GameController delega ao GameScreen a responsabilidade de desenhar os objetos na tela */
	private GameScreen gameScreen;
	
	public GameController() {
		this.gameObjects = new ArrayList<GameObject>();
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

	public void movePlayerLeft() {	
		// TODO otimizar este codigo!
		for (GameObject gameObject : gameObjects) {
			if (gameObject.type().equals("player")) {
				gameObject.move(-6f, 0f);
			}
		}	
	}
	
	public void movePlayerRight() {		
		// TODO otimizar este codigo!
		for (GameObject gameObject : gameObjects) {
			if (gameObject.type().equals("player")) {
				gameObject.move(6f, 0f);
			}
		}	
	}

}
