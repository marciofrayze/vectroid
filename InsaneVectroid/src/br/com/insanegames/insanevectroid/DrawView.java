package br.com.insanegames.insanevectroid;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {
    
	private GameController gameController;
	
    public DrawView(Context context) {
        super(context);
    }

    public void setGameController(GameController gameController) {
    	this.gameController = gameController;
    }
    
    @Override
    public void onDraw(Canvas canvas) {
    	gameController.drawWorld(canvas);
    }
    	
//	@Override
//	public boolean dispatchTouchEvent(MotionEvent motionEvent) {
//		System.out.println("Clique no DrawView dispatchTouchEvent: (" + motionEvent.getX() + ", " + motionEvent.getY() + ")");
//		return true;
//	}  

}
