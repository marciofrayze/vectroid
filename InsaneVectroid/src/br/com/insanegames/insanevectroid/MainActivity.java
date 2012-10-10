package br.com.insanegames.insanevectroid;

import java.util.Random;

import br.com.insanegames.insanevectroid.controllers.AnimationController;
import br.com.insanegames.insanevectroid.controllers.GameController;
import br.com.insanegames.insanevectroid.controllers.InputController;
import br.com.insanegames.insanevectroid.gameobjects.PlayerGameObject;
import br.com.insanegames.insanevectroid.gameobjects.RectSinGameObject;
import br.com.insanegames.insanevectroid.util.GameScreen;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.app.Activity;
import android.graphics.Color;

/**
 * Classe principal/inicial. Apenas cria a estrutura basica necessaria para execucao do jogo. 
 * Esta classe nao deve ter nenhuma responsabilidade a nao ser prover a estrutura basica.
 * @author Marcio Frayze David
 *
 */
public class MainActivity extends Activity {
    
	/** View onde iremos desenhar os objetos do jogo */
	private DrawView drawView;
	/** Thread responsavel pelo looping principal do jogo, controle de framerate, etc. */
	private AnimationController thread;
	
	private InputController inputController;
	
    
    /**
     * Metodo inicial chamado autmagicamente. Aqui instanciamos a estrutura basica necessaria para execucao do jogo.
     * @TODO: retirar toda e qualquer logica desnecessaria deste metodo. Deve fazer o minimo necessario.
     */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Criando a view onde vamos desenhar os objetos
        drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.WHITE);       
        
        GameController gameController = new GameController();
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        GameScreen gameScreen = new GameScreen(metrics.widthPixels, metrics.heightPixels);
        gameController.setGameScreen(gameScreen);
        
        // Criando uns objetos quaisquer apenas para testes
        Random rnd = new Random(); 
        for (int i=0; i<5; i++) {
        	int posXInicial = (int) (1 + (Math.random() * 420));
        	//int width = (int) (1 + (Math.random() * 640)/40);
        	//int height = (int) (1 + (Math.random() * 640)/40);
        	int width = 50;
        	int height = 50;
        	int posYInicial = (int) (1 + (Math.random() * 300));
        	float vel = (float)Math.random();        	
        	int color = Color.argb(255,rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        	gameController.addGameObject(new RectSinGameObject(posXInicial, -posYInicial, width, height, vel, color));
        }
        
        PlayerGameObject playerGameObject = new PlayerGameObject(1024/2, 700, 50, 50, 0.3f, Color.BLUE);
        gameController.addGameObject(playerGameObject);
        	
        // A DrawView precisa ter acesso ao gameController pois infelizmente eh um metodo dela que eh acionado automaticamente pelo android
        // e eh este metodo que tem acesso ao canvas onde vamos desenhar. A DrawView ira delegar a responsabilidade da logica do jogo ao GameController.
        // @TODO: Tentar rever isso para tentar tirar da DrawView a dependencia com GameController. Nao faz muito sentido a view depender do controller...
        drawView.setGameController(gameController);

        // Thread responsavel pelo looping principal. Apenas delega ao gameController as responsabilidades.
        thread = new AnimationController();        
        thread.setGameController(gameController);
        // Por enquanto a thread depende da view pois ela eh quem chama o metodo postInvalidate, que forca a re-renderizacao da view.
        // TODO: Rever essa dependencia. Talvez fosse melhor o controller chamar o postInvalidate da view e nao a thread. Pensar sobre isso!
        thread.setView(drawView);
        thread.start();
        
        setContentView(drawView);
        
        inputController = new InputController(gameController, gameScreen.getScreenSize());
    }
	
	@Override
	public boolean onTouchEvent(MotionEvent motionEvent) {
		System.out.println("Clique: (" + motionEvent.getX() + ", " + motionEvent.getY() + ")");
		inputController.onMotionEvent(motionEvent);		
		return true;
	}
}
