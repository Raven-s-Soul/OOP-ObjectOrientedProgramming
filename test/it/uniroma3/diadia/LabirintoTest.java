package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LabirintoTest {

	
	Labirinto Labirinto;
	
	@BeforeEach
    void setUp(){
		Labirinto = new Labirinto();
    }
	
	@Test
	void testSetStanzaNull() {
		Labirinto.setStanzaAttuale(null);
		assertNull(Labirinto.getStanzaAttuale());
	}
	
	@Test
	void testStanzaNullStanzaVincente() {
		Stanza stanza = new Stanza("test");
		Labirinto.setStanzaAttuale(null);
		Labirinto.setStanzaFinale(stanza);
		assertNotEquals(Labirinto.getStanzaAttuale() , Labirinto.getStanzaFinale());
	}
}
