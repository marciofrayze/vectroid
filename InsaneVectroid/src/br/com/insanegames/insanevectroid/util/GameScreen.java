package br.com.insanegames.insanevectroid.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import br.com.insanegames.insanevectroid.GameObject;
import br.com.insanegames.insanevectroid.Line;

public class GameScreen {

	private int realWidth;
	private int realHeight;
	private Paint paint;

	public GameScreen(int width, int height) {
		this.realWidth = width;
		this.realHeight = height;
		this.paint = new Paint();
	}

	public int getRealWidth() {
		return realWidth;
	}

	public void setRealWidth(int width) {
		this.realWidth = width;
	}

	public int getRealHeight() {
		return realHeight;
	}

	public void setRealHeight(int height) {
		this.realHeight = height;
	}

	public void drawGameObject(GameObject gameObject, Canvas canvas) {
		for (Line line : gameObject.getLines()) {
			paint.setColor(gameObject.getColor());					
			canvas.drawLine( xReal(line.startPosition.getX()), yReal(line.startPosition.getY()), xReal(line.endPosition.getX()), yReal(line.endPosition.getY()), paint);
		}
	}

	// Para o programador, a tela eh como se tivesse uma resolucao 1024x768. Aqui convertemos esses valores para valores proporcionais 
	// dependendo do tamanho da tela
	public int xReal(float xRelativo) {
		return (int) (xRelativo * realWidth) / 1024;
	}
	
	public int yReal(float yRelativo) {
		return (int) (yRelativo * realHeight) / 768;
	}	
	
}