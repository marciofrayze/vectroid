package br.com.insanegames.insanevectroid;

import android.view.View;

public class AnimationThread extends Thread {
	
	private GameController gameController;
	private View view;
	long startTime; // usado para controlar framerate

	@Override
	public void run() {
		startTime = System.currentTimeMillis();
		while(true) {
			this.waitFrameRate();
			gameController.updateWorld();
			view.postInvalidate();
		}
	}
	
	private void waitFrameRate() {
    	try {
			long endTime = System.currentTimeMillis();
			long dt = endTime - startTime;
		    if (dt < 10) {
					Thread.sleep(10 - dt);
		    }
		    startTime = System.currentTimeMillis();
    	} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}
	
	public void setView(View view) {
		this.view = view;
	}
	

}
