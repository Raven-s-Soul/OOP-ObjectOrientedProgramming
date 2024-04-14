package it.uniroma3.diadia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {

	
	Labirinto Labirinto;
	Stanza test;
	
	@BeforeEach
    void setUp(){
		Labirinto = new Labirinto();
		test= new Stanza("test");
	}
	
	@Test
	void testSetStanzaNull() {
		Labirinto.setStanzaAttuale(null);
		assertNull(Labirinto.getStanzaAttuale());
	}
	
	@Test
	void testStanzaNullStanzaVincente() {
		Labirinto.setStanzaAttuale(null);
		Labirinto.setStanzaFinale(test);
		assertNotEquals(Labirinto.getStanzaAttuale() , Labirinto.getStanzaFinale());
	}
	
	@Test
	void testStanzaLabirintoVuoto() {
		Labirinto.addStanza(null);
		assertTrue(Labirinto.StanzaInLabirinto(null));
	}
	
	@Test
	void testStanzaLabirintoUnaStanza() {
		Labirinto.addStanza(test);
		assertTrue(Labirinto.StanzaInLabirinto(test));
	}
	
	@Test
	void testStanzaLabirintoStanzaNonPresente() {
		assertFalse(Labirinto.StanzaInLabirinto(test));		
	}
	
	@Test 
	void testSetStanzaIniziale() {
		Labirinto.setStanzaIniziale(test);
		assertTrue(Labirinto.StanzaInLabirinto(test));
	}
	
	@Test 
	void testSetStanzaFinale() {
		Labirinto.setStanzaFinale(test);
		assertTrue(Labirinto.StanzaInLabirinto(test));
	}	
	
	@Test 
	void testSetStanzaAttuale() {
		Labirinto.setStanzaAttuale(test);
		assertTrue(Labirinto.StanzaInLabirinto(test));
	}	
	
	@Test
	void testAddStanza() {
		Stanza stanzaTest;
		int value=10;
		for(int i = 0; i < value; i++ ) {
			stanzaTest = new Stanza( Integer.toString(i)); // ""+i
			Labirinto.addStanza(stanzaTest);
		}
		assertEquals(Labirinto.getStanze().length, value);
	}
	
}
