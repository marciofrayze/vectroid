package br.com.insanegames.insanevectroid;


import br.com.insanegames.insanevectroid.controllers.AnimationController;
import br.com.insanegames.insanevectroid.controllers.GameController;
import br.com.insanegames.insanevectroid.controllers.InputController;
import br.com.insanegames.insanevectroid.util.GameScreen;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.app.Activity;
import android.graphics.Color;

/**
 * Classe principal/inicial. Apenas cria a estrutura basica necessaria para execucao do jogo. 
 * Esta classe nao deve ter nenhuma responsabilidade a nao ser prover a estrutura basica.
 * Classe abstrata. Deve ser extendida e adaptada para as necessidades de cada jogo.
 * @author Marcio Frayze David
 *
 */
public abstract class AbstractMainActivity extends Activity {
    
	/** View onde iremos desenhar os objetos do jogo */
	protected DrawView drawView;
	/** Thread responsavel pelo looping principal do jogo, controle de framerate, etc. */
	protected AnimationController thread;	
	protected InputController inputController;
	protected GameController gameController;

	protected GameScreen gameScreen;
    
    /**
     * Metodo inicial chamado autmagicamente. Aqui instanciamos a estrutura basica necessaria para execucao do jogo.
     * @TODO: retirar toda e qualquer logica desnecessaria deste metodo. Deve fazer o minimo necessario.
     */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        gameScreen = new GameScreen(metrics.widthPixels, metrics.heightPixels);

        this.gameSetup();
        
        // viewSetup e startAnimationController precisam ser depois do gameSetup e o gameSetup deve instanciar o gameController senao vai dar erro!
        this.viewSetup();
        this.startAnimationController();
    }	

	/**
	 * Faz o setup da view. Chamado automaticamente no onCreate.
	 */
	private void viewSetup() {
	    // Criando a view onde vamos desenhar os objetos
	    drawView = new DrawView(this);
	    drawView.setBackgroundColor(Color.WHITE);       
	    // A DrawView precisa ter acesso ao gameController pois infelizmente eh um metodo dela que eh acionado automaticamente pelo android
	    // e eh este metodo que tem acesso ao canvas onde vamos desenhar. A DrawView ira delegar a responsabilidade da logica do jogo ao GameController.
	    // @TODO: Tentar rever isso para tentar tirar da DrawView a dependencia com GameController. Nao faz muito sentido a view depender do controller...
	    drawView.setGameController(gameController);
	    setContentView(drawView);		
	}

	/**
	 * Setut inicial do seu jogo.
	 * Quando for implementar este metodo, nao esqueca de instanciar os game controllers
	 */	
	protected abstract void gameSetup();

	@Override
	public boolean onTouchEvent(MotionEvent motionEvent) {
		System.out.println("Clique: (" + motionEvent.getX() + ", " + motionEvent.getY() + ")");
		inputController.onMotionEvent(motionEvent);		
		return true;
	}

	/**
	 * Instancia uma nova thread responsavel pelo controle das animacoes, framerate, looping principal do jogo, etc.
	 * Nao esqueca de instanciar os atributos necessarios antes de chamar este metodo (dica: chame no final do seu metodo gameSetup())
	 */
	protected void startAnimationController() {
	    // Thread responsavel pelo looping principal. Apenas delega ao gameController as responsabilidades.
	    thread = new AnimationController();        
	    thread.setGameController(gameController);
	    // Por enquanto a thread depende da view pois ela eh quem chama o metodo postInvalidate, que forca a re-renderizacao da view.
	    // TODO: Rever essa dependencia. Talvez fosse melhor o controller chamar o postInvalidate da view e nao a thread. Pensar sobre isso!
	    thread.setView(drawView);
	    thread.start();
	}

}