package br.com.insanegames.insanevectroid;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {
    
	private Paint paint = new Paint();
	private GameController gameController;

    public DrawView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
    }

    public void setGameController(GameController gameController) {
    	this.gameController = gameController;
    }
    
    @Override
    public void onDraw(Canvas canvas) {
    	gameController.updateWorld();
    	gameController.drawWorld(canvas);
    }
    

}