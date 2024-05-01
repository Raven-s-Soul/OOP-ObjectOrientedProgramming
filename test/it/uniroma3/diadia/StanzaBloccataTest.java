package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StanzaBloccataTest {

    Stanza stanza;
    StanzaBloccata bloccata;
    Attrezzo attrezzo1;
    Attrezzo attrezzo2;

    @BeforeEach
    void setUp() {
        stanza = new Stanza("adiacente");
        attrezzo1 = new Attrezzo("testA1", 1);
        bloccata = new StanzaBloccata("bloccata", "nord", "testA1");
        attrezzo2 = new Attrezzo("testA2", 2);

        bloccata.impostaStanzaAdiacente("nord", stanza);
    }

    @Test
    void testAttrezzoNonValido() {
        bloccata.addAttrezzo(attrezzo2);
        assertEquals(bloccata, bloccata.getStanzaAdiacente("nord"));
    }


    @Test
    void testAttrezzoValido() {
        bloccata.addAttrezzo(attrezzo1);
        assertEquals(stanza, bloccata.getStanzaAdiacente("nord"));
    }

}
