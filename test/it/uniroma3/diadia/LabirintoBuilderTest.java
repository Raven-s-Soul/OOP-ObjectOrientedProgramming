package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoBuilderTest {
	
	Labirinto lab;
	
	@BeforeEach
	void setUp() {
		lab= new Labirinto();
	}
	
	
	@Test
	void testAddStanzaIniziale() {
		lab= new LabirintoBuilder().addStanzaIniziale("test").getLabirinto();
		
		assertEquals("test", lab.getStanzaIniziale().getNome());
	}
	
	@Test
	void testAddStanzaVincente() {
		lab= new LabirintoBuilder().addStanzaVincente("test").getLabirinto();
		
		assertEquals("test", lab.getStanzaFinale().getNome());
	}
	
	@Test
	void testAddStanzaAdiacente() {
		Stanza s= new Stanza("corrente");
		lab.addStanza(s);
		
		lab= new LabirintoBuilder(lab).addAdiacenza("corrente", "adiac", "nord").getLabirinto();
		
		assertEquals(s, lab.cercaStanzaInLabirinto("corrente"));
		assertEquals("adiac", s.getStanzaAdiacente("nord").getNome());
	}

	
	@Test
	void testAddAttrezzo() {
		
		lab= new LabirintoBuilder().addStanza("sTest").addAttrezzo("aTest", 1).getLabirinto();
		
		assertEquals("aTest", lab.cercaStanzaInLabirinto("sTest").getAttrezzo("aTest").getNome());
	}
	
	@Test
	void testAddStanza() {
		lab= new LabirintoBuilder().addStanza("test").getLabirinto();
		
		assertEquals("test", lab.cercaStanzaInLabirinto("test").getNome());
	}
	
	
	
	

}
