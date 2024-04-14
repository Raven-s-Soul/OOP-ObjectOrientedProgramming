package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	Borsa borsa;
	Attrezzo ATest;
	
	@BeforeEach
	void setUp() {
		borsa= new Borsa();
		ATest= new Attrezzo("test",1);
	}

	@Test
	void testRemoveUnSoloAttrezzo() {
		
		borsa.addAttrezzo(ATest);
		assertEquals(borsa.removeAttrezzo("test"), ATest);
	}
	
	@Test
	void testRemoveAttrezzoDaBorsaVuota() {
		assertEquals(borsa.removeAttrezzo("test"), null);
		
	}

}
