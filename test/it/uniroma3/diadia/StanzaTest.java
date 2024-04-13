package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaTest {

	Stanza stanza;
	
	@BeforeEach
    void setUp(){
		stanza= new Stanza("Test");
    }
	
	@Test
	void testCostruttore() {
		assertNotEquals(stanza,null);
	}
	
	@Test
	void testImpostaStanzaAdiacenteNull() {
		stanza.impostaStanzaAdiacente("nord", null);
		assertEquals(stanza.getStanzaAdiacente("nord") , null);
	}
	
	@Test
	void testImpostaStanzaAdiacente() {
		Stanza test = new Stanza("Test") ;
		stanza.impostaStanzaAdiacente("nord", test);
		assertEquals(stanza.getStanzaAdiacente("nord") , test);
	}
	
	@Test // Override su stanza nella stessa direzione
	void testImpostaStanzaAdiacenteOverride() {
		Stanza test = new Stanza("Test") ;
		Stanza test2 = new Stanza("Test2") ;
		stanza.impostaStanzaAdiacente("nord", test);
		stanza.impostaStanzaAdiacente("nord", test2);
		assertEquals(stanza.getStanzaAdiacente("nord") , test2);
	}
	
	@Test
	void testArrayAttrezzi() {
		Attrezzo AttrezzoTest;
		for(int i = 0; i < stanza.getMaxAttrezzi(); i++ ) {
			AttrezzoTest = new Attrezzo("OggettoTest", i );
			stanza.addAttrezzo(AttrezzoTest);
		}
		assertEquals(stanza.getAttrezzi().length , stanza.getMaxAttrezzi());
	}
	
	@Test
	void testAttrezziPienoNull() {
		for(int i = 0; i < stanza.getMaxAttrezzi(); i++ ) {
			stanza.addAttrezzo(null);
		}
		assertEquals(stanza.getAttrezzi().length , stanza.getMaxAttrezzi());
	}
	
	@Test
	void testAttrezziPieno() {
		for(int i = 0; i < stanza.getMaxAttrezzi(); i++ ) {
			stanza.addAttrezzo(null);
		}
		assertEquals(stanza.addAttrezzo(null) , false);
	}
	
	@Test
	void testHasAttrezzo() {
		Attrezzo AttrezzoTest = new Attrezzo("test", 1);
		stanza.addAttrezzo(AttrezzoTest);
		assertEquals(stanza.hasAttrezzo("test") , true);
	}
	
	@Test
	void testHasAttrezzoVuoto() {
		stanza.addAttrezzo(null); // Come non inserire nulla
		assertEquals(stanza.hasAttrezzo(null) , false);
	}
	
	@Test
	void testHasAttrezzoNonPresente() {
		assertEquals(stanza.hasAttrezzo("Elemento") , false);
	}
	
	
	@Test
	void testHasAttrezzoPieno() {
		Attrezzo AttrezzoTest;
		for(int i = 0; i < stanza.getMaxAttrezzi(); i++ ) {
			AttrezzoTest = new Attrezzo( Integer.toString(i) , i ); // ""+i
			stanza.addAttrezzo(AttrezzoTest);
		}
		assertEquals(stanza.hasAttrezzo("Elemento") , false);
	}
	
	@Test
	void testGetAttrezzo() {
		Attrezzo AttrezzoTest = new Attrezzo("test", 1);
		stanza.addAttrezzo(AttrezzoTest);
		assertEquals(stanza.getAttrezzo("test") , AttrezzoTest);
	}
	
	@Test
	void testGetAttrezzoNull() {
		assertEquals(stanza.getAttrezzo(null) , null);
	}
	
	@Test
	void testGetAttrezzoArrayPieno() {
		Attrezzo AttrezzoTest;
		for(int i = 0; i < stanza.getMaxAttrezzi(); i++ ) {
			AttrezzoTest = new Attrezzo( Integer.toString(i) , i );
			stanza.addAttrezzo(AttrezzoTest);
		}
		// Array Pieno, inserimenti successivi bloccati.
		AttrezzoTest = new Attrezzo( "Elemento" , 0 );
		stanza.addAttrezzo(AttrezzoTest);
		assertEquals(stanza.getAttrezzo("Elemento") , null);
	}
	
	
	// TODO finire
	@Test
	void testGetDirezioni() {
		
		//assertSame(stanza.getDirezioni().toString() , new String[1] );
	}
	
	
	// removeAttrezzo

}
