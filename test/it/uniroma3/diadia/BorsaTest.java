package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class BorsaTest {
    Borsa borsa;
    Borsa borsaPiena;
    Attrezzo ATest;
    Attrezzo ATest2;
    //Set<Attrezzo> set;
    Borsa borsaOrdinata;
    Attrezzo pb, ps, pm, lb;

    @BeforeEach
    void setUp() {
        borsa = new Borsa();
        borsaPiena = new Borsa();
        ATest = new Attrezzo("test", 1);
        borsaPiena.addAttrezzo(ATest);
        ATest2 = new Attrezzo("test2", 11);
        borsaOrdinata= new Borsa(100);
        //set= new HashSet<>();
        pb=new Attrezzo("piombo", 10);
        ps=new Attrezzo("ps", 5);
        pm=new Attrezzo("piuma", 1);
        lb=new Attrezzo("libro", 5);
        borsaOrdinata.addAttrezzo(pb);
        borsaOrdinata.addAttrezzo(ps);
        borsaOrdinata.addAttrezzo(pm);
        borsaOrdinata.addAttrezzo(lb);
    
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
            ATest2 = new Attrezzo("Oggetto Test "+ i, 1);
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
    
    @Test
    void testGetContenutoOrdinatoPerPeso() {
    	List<Attrezzo> l= new ArrayList<Attrezzo>();	

    	l.add(0, pm);
    	l.add(1, lb);
    	l.add(2, ps);
    	l.add(3, pb);
    	
    	assertEquals(l, borsaOrdinata.getContenutoOrdinatoPerPeso());
    }
    
    @Test
    void testGetContenutoOrdinatoPerNome() {
    	SortedSet<Attrezzo> l= new TreeSet<Attrezzo>();
    	l.add(lb);
    	l.add(pb);
    	l.add(pm);
    	l.add(ps);
    	
    	assertEquals(l, borsaOrdinata.getContenutoOrdinatoPerNome());	//nullPointer
    }
    
    @Test
    void testGetContenutoRaggruppatoPerPeso() {
    	Set<Attrezzo> s1= new HashSet<>();
    	Set<Attrezzo> s2= new HashSet<>();
    	Set<Attrezzo> s3= new HashSet<>();
    	s1.add(pm);
    	s2.add(lb);
    	s2.add(ps);
    	s3.add(pb);
    	
    	
    	Map<Integer, Set<Attrezzo>> l= new HashMap<>();
    	  	
    	l.put(1, s1);
    	l.put(5, s2);
    	l.put(10, s3);
    	assertEquals(l, borsaOrdinata.getContenutoRaggruppatoPerPeso());
    }
    
  
    @Test
    void testGetSortedSetOrdinatoPerPeso() {
    	Attrezzo a1= new Attrezzo("a1", 1);
    	Attrezzo a2= new Attrezzo("a2", 1);
    	Borsa b= new Borsa();
    	b.addAttrezzo(a1);
    	b.addAttrezzo(a2);
    	
    	SortedSet<Attrezzo> l= new TreeSet<Attrezzo>();
    	l.add(a1);
    	l.add(a2);
    	assertEquals(l, b.getSortedSetOrdinatoPerPeso()); 	
    }

}
