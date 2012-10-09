package br.com.insanegames.insanevectroid;

import java.util.Random;
import br.com.insanegames.insanevectroid.util.GameScreen;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.app.Activity;
import android.graphics.Color;

public class MainActivity extends Activity {
    
	private DrawView drawView;
	private AnimationThread thread;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.WHITE);       
        
        GameController gameController = new GameController();
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        gameController.setGameScreen(new GameScreen(metrics.widthPixels, metrics.heightPixels));
        
        Random rnd = new Random(); 
        for (int i=0; i<5; i++) {
        	int posXInicial = (int) (1 + (Math.random() * 420));
        	int width = (int) (1 + (Math.random() * 640)/40);
        	int height = (int) (1 + (Math.random() * 640)/40);
        	int posYInicial = (int) (1 + (Math.random() * 300));
        	float vel = (float)Math.random();        	
        	int color = Color.argb(255,rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        	gameController.addGameObject(new RectSinGameObject(posXInicial, -posYInicial, width, height, vel, color));
        }
        	
        drawView.setGameController(gameController);

        thread = new AnimationThread();        
        thread.setGameController(gameController);
        thread.setView(drawView);
        thread.start();
        
        setContentView(drawView);
    }
}
