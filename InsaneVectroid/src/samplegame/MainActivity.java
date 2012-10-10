package samplegame;

import java.util.Random;


import android.graphics.Color;
import br.com.insanegames.insanevectroid.AbstractMainActivity;
import br.com.insanegames.insanevectroid.gameobjects.GameObject;

public class MainActivity extends AbstractMainActivity {
	
	/**
	 * Cria os controllers e o setup em geral do jogo
	 */
	@Override
	protected void gameSetup() {	    
		this.gameController = new VectroidGameController(this);
	    PlayerGameObject playerGameObject = new PlayerGameObject(1024/2, 700, 50, 50, 0.3f, Color.BLUE);
		gameController.addGameObject(playerGameObject);    	
	    gameController.addGameObject(criaArrayObjetosAleatoriosParaTestes());
	    
	    inputController = new VectroidInputController(gameController, gameScreen.getScreenSize());
	}
	
	private GameObject[] criaArrayObjetosAleatoriosParaTestes() {
		
		GameObject[] gameObjects = new GameObject[5];
	    // Criando uns objetos quaisquer apenas para testes
	    Random rnd = new Random(); 
	    for (int i=0; i<5; i++) {
	    	int posXInicial = (int) (1 + (Math.random() * 1024));
	    	int posYInicial = (int) (1 + (Math.random() * 768));
	    	float vel = (float)Math.random();        	
	    	int color = Color.argb(255,rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
	    	gameObjects[i] = new RectSinGameObject(posXInicial, -posYInicial, 50, 50 , vel, color); 
	    }
	    
	    return gameObjects;
	    
	}

}