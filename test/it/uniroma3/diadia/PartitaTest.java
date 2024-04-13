package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitaTest {

	Partita partita;
	
	@BeforeEach
    void setUp(){
		partita= new Partita();
    }

	@Test // Eliminabile
	void testGetSetCFU() {
		partita.setCfu(30);
		assertEquals(partita.getCfu(),30);
	}
	
	@Test
	void testSetFinita() {
		partita.setFinita();
		assertEquals(partita.isFinita(),true);
	}
	
	@Test
	void testCFUZero() {
		partita.setCfu(0);
		assertEquals(partita.isFinita(),true);
	}
	
	@Test
	void testSetVincente() {
		partita.setStanzaCorrente(partita.getStanzaVincente());
		assertEquals(partita.vinta() , true);
	}
	
	@Test
	void testSetNullCorrente() {
		partita.setStanzaCorrente(null);
		assertEquals(partita.vinta() , false);
	}
	
	@Test //controllo vittoria allo start.
    void testGetStanzaVincente() {
        assertEquals(false, partita.vinta());
    }
	
	@Test
	void testSetStanzaNull() {
		partita.setStanzaCorrente(null);
		assertNull(partita.getStanzaCorrente());
	}
	
	@Test
	void testStanzaNullStanzaVincente() {
		partita.setStanzaCorrente(null);
		assertNotEquals(partita.getStanzaCorrente() , partita.getStanzaVincente());
	}
}
