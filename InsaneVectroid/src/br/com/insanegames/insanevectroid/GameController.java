package br.com.insanegames.insanevectroid;

import java.util.ArrayList;

import br.com.insanegames.insanevectroid.util.GameScreen;
import android.graphics.Canvas;

public class GameController {
		
	private ArrayList<GameObject> gameObjects;
	private GameScreen gameScreen;
	
	public GameController() {
		this.gameObjects = new ArrayList<GameObject>();
	}
	
	public void addGameObject(GameObject... moreGameObjects) {
		for (GameObject gameObject : moreGameObjects) {
			gameObjects.add(gameObject);
		}
	}
	
	public ArrayList<GameObject> getGameObjects() {
		return this.gameObjects;
	}
	
	public void updateWorld() {
		for (GameObject gameObject : gameObjects) {
			gameObject.think();
		}			
	}
	
	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;		
	}

	public void drawWorld(Canvas canvas) {
		for (GameObject gameObject : gameObjects) {
			gameScreen.drawGameObject(gameObject, canvas);
		}			
	}

}
