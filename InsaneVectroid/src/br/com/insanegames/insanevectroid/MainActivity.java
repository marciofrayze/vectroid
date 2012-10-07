package br.com.insanegames.insanevectroid;

import java.util.Random;

import android.os.Bundle;
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
        
        Random rnd = new Random(); 
        
        GameController gameController = new GameController();
        for (int i=0; i<5; i++) {
        	int posXInicial = (int) (1 + (Math.random() * 420));
        	int width = (int) (1 + (Math.random() * 640)/40);
        	int height = (int) (1 + (Math.random() * 640)/40);
        	int posYInicial = (int) (1 + (Math.random() * 300));
        	float vel = (float)Math.random();
        	
        	int color = Color.argb(255,rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        	gameController.addGameObject(new RectSinGameObject(posXInicial, -posYInicial, width, height, vel, color));
        }
        	
        //RectGameObject rectGameObject = new RectGameObject(5, 5, 10, 10, (float)Math.random()*5, Color.BLACK);
        //RectGameObject rectGameObject2 = new RectGameObject(15, 15, 40, 40, (float)Math.random()*5, Color.BLUE);
        //RectGameObject rectGameObject3 = new RectGameObject(300, 300, 60, 60, (float)Math.random()*5, Color.BLUE);
        
        drawView.setGameController(gameController);

        thread = new AnimationThread();
        thread.setGameController(gameController);
        thread.setView(drawView);
        thread.start();
        
        setContentView(drawView);
    }
}
