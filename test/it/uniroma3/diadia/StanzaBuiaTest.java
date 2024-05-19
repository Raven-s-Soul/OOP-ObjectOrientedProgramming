package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StanzaBuiaTest {


    StanzaBuia stanza;
    Attrezzo attrezzo;

    @BeforeEach
    void setUp() {
        attrezzo = new Attrezzo("test", 1);
        stanza = new StanzaBuia("adiacente", "test");
    }


    @Test
    void testAttrezzoNonPresente() {
        assertEquals("qui c'è buio pesto!", stanza.getDescrizione());
    }


    @Test
    void testAttrezzoPresente() {
        stanza.addAttrezzo(attrezzo);
        assertNotEquals("qui c'è buio pesto!", stanza.getDescrizione());
    }

}
