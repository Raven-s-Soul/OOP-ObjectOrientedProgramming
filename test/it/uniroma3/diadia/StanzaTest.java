package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	Stanza stanza;
	Stanza test;
	Stanza stanzaAttrezziNull;
	Attrezzo AttrezzoTest;
	
	@BeforeEach
    void setUp(){
		stanza= new Stanza("Test");
		test = new Stanza("Test1") ;
		stanzaAttrezziNull= new Stanza("Test3");
		for(int i = 0; i < stanzaAttrezziNull.getMaxAttrezzi(); i++ ) {
			stanzaAttrezziNull.addAttrezzo(null);
		}
		
		AttrezzoTest= new Attrezzo("test", 1);
	}
	
	@Test
	void testCostruttore() {
		assertNotEquals(stanza,null);
	}
	
	@Test
	void testImpostaStanzaAdiacenteNull() {
		stanza.impostaStanzaAdiacente("nord", null);
		assertEquals(null, stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testImpostaStanzaAdiacente() {
		stanza.impostaStanzaAdiacente("nord", test);
		assertEquals(test, stanza.getStanzaAdiacente("nord"));
	}
	
	@Test // Override su stanza nella stessa direzione
	void testImpostaStanzaAdiacenteOverride() {
		Stanza test2 = new Stanza("Test2") ;
		stanza.impostaStanzaAdiacente("nord", test);
		stanza.impostaStanzaAdiacente("nord", test2);
		assertEquals(test2, stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testArrayAttrezzi() {
		Attrezzo AttrezzoTest2;
		for(int i = 0; i < stanza.getMaxAttrezzi(); i++ ) {
			AttrezzoTest2 = new Attrezzo("OggettoTest", i );
			stanza.addAttrezzo(AttrezzoTest2);
		}
		assertEquals(stanza.getAttrezzi().length , stanza.getMaxAttrezzi());
	}
	
	@Test
	void testAttrezziPienoNull() {
		assertEquals(stanzaAttrezziNull.getAttrezzi().length , stanzaAttrezziNull.getMaxAttrezzi());
	}
	
	@Test
	void testAttrezziPieno() {
		assertEquals(false, stanzaAttrezziNull.addAttrezzo(null));
	}
	
	@Test
	void testHasAttrezzoUnAttrezzo() {
		stanza.addAttrezzo(AttrezzoTest);
		assertEquals(true, stanza.hasAttrezzo("test"));
	}
	
	@Test
	void testHasAttrezzoVuoto() {
		stanza.addAttrezzo(null); 
		assertEquals(false, stanza.hasAttrezzo(null));
	}
	
	@Test
	void testHasAttrezzoNonPresente() {
		assertEquals(false, stanza.hasAttrezzo("Elemento"));
	}
	
	
	@Test
	void testHasAttrezzoPieno() {
		Attrezzo AttrezzoTest2;
		for(int i = 0; i < stanza.getMaxAttrezzi(); i++ ) {
			AttrezzoTest2 = new Attrezzo( Integer.toString(i) , i ); // ""+i
			stanza.addAttrezzo(AttrezzoTest2);
		}
		assertEquals(false, stanza.hasAttrezzo("Elemento"));
	}
	
	@Test
	void testGetAttrezzo() {
		stanza.addAttrezzo(AttrezzoTest);
		assertEquals(AttrezzoTest, stanza.getAttrezzo("test"));
	}
	
	@Test
	void testGetAttrezzoNull() {
		assertEquals(null, stanza.getAttrezzo(null));
	}
	
	@Test
	void testGetAttrezzoArrayPieno() {
		Attrezzo AttrezzoTest2;
		for(int i = 0; i < stanza.getMaxAttrezzi(); i++ ) {
			AttrezzoTest2 = new Attrezzo( Integer.toString(i) , i );
			stanza.addAttrezzo(AttrezzoTest2);
		}
		// Array Pieno, inserimenti successivi bloccati.
		AttrezzoTest2 = new Attrezzo( "Elemento" , 0 );
		stanza.addAttrezzo(AttrezzoTest2);
		assertEquals(null, stanza.getAttrezzo("Elemento"));
	}
	
	@Test
	void testGetDirezione() {
		Stanza arrivo= new Stanza("arrivo");
		stanza.impostaStanzaAdiacente("nord", arrivo);
		
		assertEquals("nord", stanza.getDirezioni()[0]);
	}
	
	@Test
	void testGetDirezioniRiempimentoArray() {
		Stanza arrivo= new Stanza("arrivo");
		stanza.impostaStanzaAdiacente("nord", arrivo);
		assertTrue(stanza.getDirezioni().length==1);
	}	
	
	@Test
	void testRemoveUnSoloAttrezzo() {

		stanza.addAttrezzo(AttrezzoTest);
		assertEquals(true, stanza.removeAttrezzo(AttrezzoTest));
	}
	
	@Test
	void testRemoveNessunAttrezzo() {
		assertEquals(false, stanza.removeAttrezzo(null));
	}
	
	@Test
	void testRemoveAttrezzoNonPresente() {
		assertEquals(false, stanza.removeAttrezzo(AttrezzoTest));
	}
	

}
