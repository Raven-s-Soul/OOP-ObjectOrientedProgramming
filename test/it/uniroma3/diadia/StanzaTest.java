package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StanzaTest {

    Stanza stanza;
    Stanza test;
    Stanza stanzaAttrezziNull;
    Attrezzo AttrezzoTest;

    @BeforeEach
    void setUp() {
        stanza = new Stanza("Test");
        test = new Stanza("Test1");
        stanzaAttrezziNull = new Stanza("Test3");
        for (int i = 0; i < stanzaAttrezziNull.getMaxAttrezzi(); i++) {
            stanzaAttrezziNull.addAttrezzo(null);
        }

        AttrezzoTest = new Attrezzo("test", 1);
    }

    @Test
    void testCostruttore() {
        assertNotEquals(stanza, null);
    }

    @Test
    void testImpostaStanzaAdiacenteNull() {
        stanza.impostaStanzaAdiacente("nord", null);
        assertNull(stanza.getStanzaAdiacente("nord"));
    }

    @Test
    void testImpostaStanzaAdiacente() {
        stanza.impostaStanzaAdiacente("nord", test);
        assertEquals(test, stanza.getStanzaAdiacente("nord"));
    }

    @Test
        // Override su stanza nella stessa direzione
    void testImpostaStanzaAdiacenteOverride() {
        Stanza test2 = new Stanza("Test2");
        stanza.impostaStanzaAdiacente("nord", test);
        stanza.impostaStanzaAdiacente("nord", test2);
        assertEquals(test2, stanza.getStanzaAdiacente("nord"));
    }

    @Test
    void testArrayAttrezzi() {
        Attrezzo AttrezzoTest2;
        for (int i = 0; i < stanza.getMaxAttrezzi(); i++) {
            AttrezzoTest2 = new Attrezzo("OggettoTest", i);
            stanza.addAttrezzo(AttrezzoTest2);
        }
        assertEquals(stanza.getAttrezzi().length, stanza.getMaxAttrezzi());
    }

    @Test
    void testAttrezziPienoNull() {
        assertEquals(stanzaAttrezziNull.getAttrezzi().length, stanzaAttrezziNull.getMaxAttrezzi());
    }

    @Test
    void testAttrezziPieno() {
        assertFalse(stanzaAttrezziNull.addAttrezzo(null));
    }

    @Test
    void testHasAttrezzoUnAttrezzo() {
        stanza.addAttrezzo(AttrezzoTest);
        assertTrue(stanza.hasAttrezzo("test"));
    }

    @Test
    void testHasAttrezzoVuoto() {
        stanza.addAttrezzo(null);
        assertFalse(stanza.hasAttrezzo(null));
    }

    @Test
    void testHasAttrezzoNonPresente() {
        assertFalse(stanza.hasAttrezzo("Elemento"));
    }


    @Test
    void testHasAttrezzoPieno() {
        Attrezzo AttrezzoTest2;
        for (int i = 0; i < stanza.getMaxAttrezzi(); i++) {
            AttrezzoTest2 = new Attrezzo(Integer.toString(i), i);
            stanza.addAttrezzo(AttrezzoTest2);
        }
        assertFalse(stanza.hasAttrezzo("Elemento"));
    }

    @Test
    void testGetAttrezzo() {
        stanza.addAttrezzo(AttrezzoTest);
        assertEquals(AttrezzoTest, stanza.getAttrezzo("test"));
    }

    @Test
    void testGetAttrezzoNull() {
        assertNull(stanza.getAttrezzo(null));
    }

    @Test
    void testGetAttrezzoArrayPieno() {
        Attrezzo AttrezzoTest2;
        for (int i = 0; i < stanza.getMaxAttrezzi(); i++) {
            AttrezzoTest2 = new Attrezzo(Integer.toString(i), i);
            stanza.addAttrezzo(AttrezzoTest2);
        }
        // Array Pieno, inserimenti successivi bloccati.
        AttrezzoTest2 = new Attrezzo("Elemento", 0);
        stanza.addAttrezzo(AttrezzoTest2);
        assertNull(stanza.getAttrezzo("Elemento"));
    }

    @Test
    void testGetDirezione() {
        Stanza arrivo = new Stanza("arrivo");
        stanza.impostaStanzaAdiacente("nord", arrivo);

        assertEquals("nord", stanza.getDirezioni()[0]);
    }

    @Test
    void testGetDirezioniRiempimentoArray() {
        Stanza arrivo = new Stanza("arrivo");
        stanza.impostaStanzaAdiacente("nord", arrivo);
        assertEquals(1, stanza.getDirezioni().length);
    }

    @Test
    void testRemoveUnSoloAttrezzo() {

        stanza.addAttrezzo(AttrezzoTest);
        assertTrue(stanza.removeAttrezzo(AttrezzoTest));
    }

    @Test
    void testRemoveNessunAttrezzo() {
        assertFalse(stanza.removeAttrezzo(null));
    }

    @Test
    void testRemoveAttrezzoNonPresente() {
        assertFalse(stanza.removeAttrezzo(AttrezzoTest));
    }


}
