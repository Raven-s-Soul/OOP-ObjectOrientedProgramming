package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
* Questa classe si occupa di gestire tutte le stanze (Labirinto),
* ovvero la connessione fra le stanze nenendo traccia dei attuali progressi.
*
* @author Sario Tedesco
* @see Stanza
* @version 1.0
*/
public class Labirinto {

	private static final int MaxLenghtLabirinto = 0;

	private Stanza StanzaIniziale;
	private Stanza StanzaFinale;
	private Stanza StanzaAttuale;
	private Stanza Stanze [];

	/**
	* Crea Labirinto e definisce l'array Stanze.
	*/
	public Labirinto() {
		this.Stanze = new Stanza[Labirinto.MaxLenghtLabirinto];  
	}
	
	/**
	* Controlla che nel labirinto sia presente la stanza cercata.
	*
	* @param cercare ovvero la stanza da trovare.
	* @return trovata ovvero la variabile booleana.
	*/
	public boolean StanzaInLabirinto(Stanza cercare) {
		boolean trovata = false;
		for(Stanza a : this.getStanze()) {
			if(a == cercare)
				trovata = true;
		}
		return trovata;
	}
	
	public Stanza getStanzaIniziale() {
		return StanzaIniziale;
	}
	
	/**
	* Imposta la stanza iniziale, verificando che sia presente
	* nel labirinto oppure la inserisce prima.
	*
	* @param stanzaIniziale la stanza designata.
	*/
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		if(!StanzaInLabirinto(stanzaIniziale)) 
			addStanza(stanzaIniziale);
		StanzaIniziale = stanzaIniziale;
	}
	
	/**
	*  Imposta la stanza iniziale.
	*
	* @param stanzaIniziale la stanza designata.
	*/
	public void unsafeSetStanzaIniziale(Stanza stanzaIniziale) {
		StanzaIniziale = stanzaIniziale;
	}

	public Stanza getStanzaFinale() {
		return StanzaFinale;
	}
	
	/**
	* Imposta la stanza finale, verificando che sia presente
	* nel labirinto oppure la inserisce prima.
	*
	* @param stanzaFinale la stanza designata.
	*/
	public void setStanzaFinale(Stanza stanzaFinale) {
		if(!StanzaInLabirinto(stanzaFinale)) 
			addStanza(stanzaFinale);
		StanzaFinale = stanzaFinale;
	}
	
	/**
	*  Imposta la stanza finale.
	*
	* @param stanzaFinale la stanza designata.
	*/
	public void unsafeSetStanzaFinale(Stanza stanzaFinale) {
		StanzaFinale = stanzaFinale;
	}

	public Stanza getStanzaAttuale() {
		return StanzaAttuale;
	}

	/**
	* Imposta la stanza attuale, verificando che sia presente
	* nel labirinto oppure la inserisce prima.
	*
	* @param stanzaAttuale la stanza designata.
	*/
	public void setStanzaAttuale(Stanza stanzaAttuale) {
		if(stanzaAttuale==null)
			return;
		
		if(!StanzaInLabirinto(stanzaAttuale)) 
			addStanza(stanzaAttuale);

		StanzaAttuale = stanzaAttuale;
	}
	
	/**
	*  Imposta la stanza finale.
	*
	* @param stanzaFinale la stanza designata.
	*/
	public void unsafeSetStanzaAttuale(Stanza stanzaAttuale) {	
		StanzaAttuale = stanzaAttuale;
	}
	
	public Stanza[] getStanze() {
		return Stanze;
	}

	/**
	* Inserisce una stanza al Labirinto, se non c'è
	* spazio utilizza "setNewSize" per incrementare la
	* dimensione di Labirinto.
	*
	* @param stanza da inserire
	*/
	public void addStanza(Stanza stanza) {
		if(this.getStanze().length >= Labirinto.MaxLenghtLabirinto-1)
			setNewSize(1);
		this.Stanze[this.getStanze().length-1] = stanza;
	}
	
	/**
	* Incrementare la dimensione di Labirinto.
	*
	* @param addSize numero di slot da aggiungere in Labirinto
	*/
	private void setNewSize(int addSize) {
		Stanza newLab[] = new Stanza[getStanze().length + addSize];
		int i = 0;
		for( Stanza a : this.getStanze()) {
			newLab[i] = a;
			i++;
		}
		this.Stanze = newLab;
	}

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	public void creaStanze() {

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna", 3);
		Attrezzo osso = new Attrezzo("osso", 1);

		// crea stanze del labirinto
		// Le salvo dentro Stanze[]
		Stanza atrio = new Stanza("Atrio");
		addStanza(atrio);
		Stanza aulaN11 = new Stanza("Aula N11");
		addStanza(aulaN11);
		Stanza aulaN10 = new Stanza("Aula N10");
		addStanza(aulaN10);
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		addStanza(laboratorio);
		Stanza biblioteca = new Stanza("Biblioteca");
		addStanza(biblioteca);
		
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		this.setStanzaAttuale(atrio);
		this.setStanzaFinale(biblioteca);
	}


}
