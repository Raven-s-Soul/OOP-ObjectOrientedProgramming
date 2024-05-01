package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	
	StanzaBuia stanza;
	Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() {
		attrezzo= new Attrezzo("test", 1);
		stanza= new StanzaBuia("adiacente", "test");
	}


	@Test
	void testAttrezzoNonPresente() {
		assertTrue(stanza.getDescrizione().equals("qui c'è buio pesto!"));
	}
	
	
	@Test
	void testAttrezzoPresente() {
		stanza.addAttrezzo(attrezzo);
		
		assertFalse(stanza.getDescrizione().equals("qui c'è buio pesto!"));
	}

}
