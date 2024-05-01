package it.uniroma3.diadia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ComandoPosaTest {

    Partita partita;
    ComandoPosa comando = new ComandoPosa();
    IO io = new IOConsole();
    Attrezzo attrezzo = new Attrezzo("test", 1);

    @BeforeEach
    void setUp() {
        partita = new Partita(io);

    }

    @Test
    void testPosaDaBorsaVuota() {
        comando.esegui(partita);
        assertTrue(partita.getGiocatore().getBorsa().isEmpty());
    }

    @Test
    void testPosaDaBorsaUnElemento() {
        partita.getGiocatore().addAttrezzoToBorsa(attrezzo);
        comando.setParametro(attrezzo.getNome());
        comando.esegui(partita);

        assertTrue(partita.getGiocatore().getBorsa().isEmpty());
    }

    @Test
    void testPosaDaBorsaConDueElementi() {
        partita.getGiocatore().addAttrezzoToBorsa(attrezzo);
        Attrezzo attrezzo2 = new Attrezzo("test2", 2);
        partita.getGiocatore().addAttrezzoToBorsa(attrezzo2);
        comando.setParametro(attrezzo.getNome());
        comando.esegui(partita);

        assertEquals(1, partita.getGiocatore().getBorsa().getNumAttrezzi());
    }
}
