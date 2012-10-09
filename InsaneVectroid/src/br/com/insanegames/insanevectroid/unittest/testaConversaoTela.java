package br.com.insanegames.insanevectroid.unittest;

import org.junit.Test;

import br.com.insanegames.insanevectroid.util.GameScreen;

import junit.framework.Assert;
import junit.framework.TestCase;

public class testaConversaoTela extends TestCase {

	@Test
	public void testaXReal() {
		GameScreen gameScreen = new GameScreen(1024, 768);
		Assert.assertEquals(1024, gameScreen.xReal(1024));
		Assert.assertEquals(768, gameScreen.xReal(768));
		
	}
}
