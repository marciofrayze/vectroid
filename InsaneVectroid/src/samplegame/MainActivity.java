package samplegame;

import android.graphics.Color;
import br.com.insanegames.insanevectroid.AbstractMainActivity;
import br.com.insanegames.insanevectroid.gameobjects.GameObject;
import br.com.insanegames.insanevectroid.util.GameScreen;

public class MainActivity extends AbstractMainActivity {
	
	/**
	 * Cria os controllers e o setup em geral do jogo
	 */
	@Override
	protected void gameSetup() {	    
		this.gameController = new VectroidGameController(this);
	    
		// cria uns inimigos aleatorios
		gameController.addGameObject(criaArrayObjetosAleatoriosParaTestes());
		
		// cria o jogador, e seta no controller
	    PlayerGameObject player = new PlayerGameObject(1024/2, 700, 50, 50, 0.3f, Color.BLUE);
	    // TODO: dar um jeito de arrancar esse cast bizarro
	    ((VectroidGameController)gameController).setPlayer(player);
	    
	    inputController = new VectroidInputController(gameController, gameScreen.getScreenSize());
	}
	
	private GameObject[] criaArrayObjetosAleatoriosParaTestes() {		
		
	    // Criando uns objetos quaisquer apenas para testes
		GameObject[] gameObjects = new GameObject[5];		
	    for (int i=0; i<5; i++) {
	    	float vel = (float)Math.random();        	
	    	gameObjects[i] = new RectSinGameObject(GameScreen.randomXPosition(), -GameScreen.randomYPosition(), 50, 50 , vel, GameScreen.randomColor()); 
	    }
	    
	    return gameObjects;	    
	}

}