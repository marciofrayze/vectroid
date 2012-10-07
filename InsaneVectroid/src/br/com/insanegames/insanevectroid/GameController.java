package br.com.insanegames.insanevectroid;

import java.util.ArrayList;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GameController {
		
	private ArrayList<GameObject> gameObjects;
	private Paint paint;
	
	public GameController() {
		this.gameObjects = new ArrayList<GameObject>();
		this.paint = new Paint();
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
	
	public void drawWorld(Canvas canvas) {
		for (GameObject gameObject : gameObjects) {
			for (Line line : gameObject.getLines()) {
				paint.setColor(gameObject.getColor());
				canvas.drawLine(line.startPosition.getX(), line.startPosition.getY(), line.endPosition.getX(), line.endPosition.getY(), paint);
			}
		}
	}

}
