package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ComandoPrendiTest {
	
	Partita partita;
	ComandoPrendi comando= new ComandoPrendi();
	IO io= new IOConsole();
	Attrezzo attrezzo= new Attrezzo("test", 1);
	
	
	@BeforeEach
	void setUp() {
		partita= new Partita(io);	
	}
	
	
	@Test
	void testPrendiDaStanzaVuota() {
		partita.getLabirinto().getStanzaAttuale().getStanzaAdiacente("est");
		comando.setParametro(null);
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().isEmpty());
	}
	
	@Test
	void  testPrendiDaStanzaUnAttrezzo() {
		partita.getLabirinto().getStanzaAttuale().addAttrezzo(attrezzo);
		comando.setParametro("test");
		comando.esegui(partita);
		assertEquals(1, partita.getLabirinto().getStanzaAttuale().getNumAttrezzi());
	}
	
	@Test
	void  testPrendiUnAttrezzo() {
		partita.getLabirinto().getStanzaAttuale().addAttrezzo(attrezzo);
		comando.setParametro("test");
		comando.esegui(partita);
		assertEquals(1, partita.getGiocatore().getBorsa().getNumAttrezzi());
	}
}
