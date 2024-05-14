package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StanzaMagicaTest {

    StanzaMagica stanzaMagica;

    @BeforeEach
    void setUp() {
        stanzaMagica = new StanzaMagica("Test");
    }

    @Test
    void testAddAttrezzoNull() {
        assertFalse(stanzaMagica.addAttrezzo(null));
    }

    @Test
    void testAddAttrezzo() {
        Attrezzo attrezzo = new Attrezzo("Attrezzo", 1);
        assertTrue(stanzaMagica.addAttrezzo(attrezzo));
    }

    @Test
    void testAddAttrezzoMagico() {
        int peso = 2;
        Attrezzo attrezzo = new Attrezzo("Attrezzo", peso);
        stanzaMagica.addAttrezzo(attrezzo);
        stanzaMagica.addAttrezzo(attrezzo);
        stanzaMagica.addAttrezzo(attrezzo);
        stanzaMagica.addAttrezzo(attrezzo); // Magico
        // String Builder
        StringBuilder stringBuilder = new StringBuilder(attrezzo.getNome());
        stringBuilder.reverse();
        assertEquals(peso * 2, stanzaMagica.getAttrezzo(stringBuilder.toString()).getPeso());
    }

}
