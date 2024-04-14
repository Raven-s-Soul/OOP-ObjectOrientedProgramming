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
		assertEquals(null, stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testImpostaStanzaAdiacente() {
		Stanza test = new Stanza("Test") ;
		stanza.impostaStanzaAdiacente("nord", test);
		assertEquals(test, stanza.getStanzaAdiacente("nord"));
	}
	
	@Test // Override su stanza nella stessa direzione
	void testImpostaStanzaAdiacenteOverride() {
		Stanza test = new Stanza("Test") ;
		Stanza test2 = new Stanza("Test2") ;
		stanza.impostaStanzaAdiacente("nord", test);
		stanza.impostaStanzaAdiacente("nord", test2);
		assertEquals(test2, stanza.getStanzaAdiacente("nord"));
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
		assertEquals(false, stanza.addAttrezzo(null));
	}
	
	@Test
	void testHasAttrezzo() {
		Attrezzo AttrezzoTest = new Attrezzo("test", 1);
		stanza.addAttrezzo(AttrezzoTest);
		assertEquals(true, stanza.hasAttrezzo("test"));
	}
	
	@Test
	void testHasAttrezzoVuoto() {
		stanza.addAttrezzo(null); // Come non inserire nulla
		assertEquals(false, stanza.hasAttrezzo(null));
	}
	
	@Test
	void testHasAttrezzoNonPresente() {
		assertEquals(false, stanza.hasAttrezzo("Elemento"));
	}
	
	
	@Test
	void testHasAttrezzoPieno() {
		Attrezzo AttrezzoTest;
		for(int i = 0; i < stanza.getMaxAttrezzi(); i++ ) {
			AttrezzoTest = new Attrezzo( Integer.toString(i) , i ); // ""+i
			stanza.addAttrezzo(AttrezzoTest);
		}
		assertEquals(false, stanza.hasAttrezzo("Elemento"));
	}
	
	@Test
	void testGetAttrezzo() {
		Attrezzo AttrezzoTest = new Attrezzo("test", 1);
		stanza.addAttrezzo(AttrezzoTest);
		assertEquals(AttrezzoTest, stanza.getAttrezzo("test"));
	}
	
	@Test
	void testGetAttrezzoNull() {
		assertEquals(null, stanza.getAttrezzo(null));
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
		assertEquals(null, stanza.getAttrezzo("Elemento"));
	}
	
	
	// TODO finire
	@Test
	void testGetDirezioni() {
		//assertSame(stanza.getDirezioni().toString() , new String[1] );
		
		/*String[] s= new String[stanza.getNumStanzeAdiacenti()];*/
		assertEquals(stanza.getDirezioni().length, 0);
	}
	
	@Test
	void testGetDir2() {
		Stanza arrivo= new Stanza("arrivo");
		stanza.impostaStanzaAdiacente("nord", arrivo);
		
		assertEquals(stanza.getDirezioni()[0], "nord");
	}
	
	@Test
	void testGetDir3() {
		Stanza arrivo= new Stanza("arrivo");
		stanza.impostaStanzaAdiacente("nord", arrivo);
		
		assertTrue(stanza.getDirezioni().length==1);
	}	
	
	
	@Test
	void testRemoveUnSoloAttrezzo() {
		Attrezzo ATest= new Attrezzo("test", 1);
		stanza.addAttrezzo(ATest);
		
		assertEquals(true, stanza.removeAttrezzo(ATest));
	}
	
	@Test
	void testRemoveNessunAttrezzo() {
		assertEquals(false, stanza.removeAttrezzo(null));
	}
	
	@Test
	void testRemoveAttrezzoNonPresente() {
		Attrezzo ATest=new Attrezzo("test", 1);
		assertEquals(false, stanza.removeAttrezzo(ATest));
	}
	

}
