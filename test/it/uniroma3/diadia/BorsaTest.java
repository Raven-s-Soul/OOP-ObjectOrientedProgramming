package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BorsaTest {
    Borsa borsa;
    Borsa borsaPiena;
    Attrezzo ATest;
    Attrezzo ATest2;

    @BeforeEach
    void setUp() {
        borsa = new Borsa();
        borsaPiena = new Borsa();
        ATest = new Attrezzo("test", 1);
        borsaPiena.addAttrezzo(ATest);
        ATest2 = new Attrezzo("test2", 11);
    }


    @Test
    void testAddAttrezzoNull() {
        assertFalse(borsa.addAttrezzo(null));
    }

    @Test
    void testAddAttrezzoBorsaPesante() {
        assertFalse(borsa.addAttrezzo(ATest2));
    }

    @Test
    void testAddAttrezzoBorsaPiena() {
        borsaPiena = new Borsa();
        for (int i = 0; i < borsa.getPesoMax(); i++) {
            ATest2 = new Attrezzo("Oggetto Test", 1);
            borsaPiena.addAttrezzo(ATest2);
        }
        assertFalse(borsaPiena.addAttrezzo(ATest));

    }

    @Test
    void testAddAttrezzoUnico() {
        assertTrue(borsa.addAttrezzo(ATest));
    }


    @Test
    void testGetAttrezzo() {
        assertEquals(ATest, borsaPiena.getAttrezzo("test"));
    }

    @Test
    void testGetAttrezzoInsesistente() {
        assertNull(borsa.getAttrezzo("test"));
    }

    @Test
    void testGetPesoBorsaVuota() {
        assertEquals(0, borsa.getPeso());
    }

    @Test
    void testGetPesoBorsaUnElemento() {
        borsa.addAttrezzo(ATest);
        assertEquals(ATest.getPeso(), borsa.getPeso());
    }


    @Test
    void testIsEmpty() {
        assertTrue(borsa.isEmpty());
    }

    @Test
    void testIsEmpty2() {
        assertFalse(borsaPiena.isEmpty());
    }


    @Test
    void testRemoveUnSoloAttrezzo() {
        assertEquals(borsaPiena.removeAttrezzo("test"), ATest);
    }

    @Test
    void testRemoveAttrezzoDaBorsaVuota() {
        assertNull(borsa.removeAttrezzo("test"));

    }

    @Test
    void testRemoveAttrezzoNonPresenteInBorsa() {
        assertNull(borsaPiena.removeAttrezzo("test2"));

    }

}
