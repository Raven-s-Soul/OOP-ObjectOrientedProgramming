package it.uniroma3.diadia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PartitaTest {

    Partita partita;

    @BeforeEach
    void setUp() {
        partita = new Partita();
    }

    @Test
    void testSetVincente() {
        partita.getLabirinto().setStanzaAttuale(partita.getLabirinto().getStanzaFinale());
        assertTrue(partita.vinta());
    }

    @Test
    void testCFUZero() {
        partita.getGiocatore().setCfu(0);
        assertTrue(partita.isFinita());
    }

    @Test
    void testSetNullCorrente() {
        partita.getLabirinto().setStanzaAttuale(null);
        assertFalse(partita.vinta());
    }

    @Test
    void testSetFinita() {
        partita.setFinita();
        assertTrue(partita.isFinita());
    }

    @Test
    void testGetStanzaVincente() {
        //controllo vittoria allo start.
        assertFalse(partita.vinta());
    }


}
