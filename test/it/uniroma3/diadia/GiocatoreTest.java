package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GiocatoreTest {

    Giocatore giocatore;
    int cfu;
    Attrezzo ATest;

    @BeforeEach
    void setUp() {
        giocatore = new Giocatore();
        giocatore.setCfu(1);
        ATest = new Attrezzo("test", 1);
        giocatore.addAttrezzoToBorsa(ATest);
    }

    @Test
    void testGetCfu() {
        assertEquals(1, giocatore.getCfu());
    }

    @Test
    void testRemoveAttrezzoDaBorsa() {
        assertEquals(ATest, giocatore.removeAttrezzoDaBorsa("test"));
    }

    @Test
    void testRemoveAttrezzoDaBorsaVuota() {
        Giocatore giocatore2 = new Giocatore();
        assertNull(giocatore2.removeAttrezzoDaBorsa("test"));
    }


}
