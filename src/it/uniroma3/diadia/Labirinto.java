package it.uniroma3.diadia;

public class Labirinto {

	private static final int MaxLenghtLabirinto = 0;

	private Stanza StanzaIniziale;
	private Stanza StanzaFinale;
	private Stanza StanzaAttuale;
	private Stanza Stanze [];

	Labirinto() {
		this.Stanze = new Stanza[Labirinto.MaxLenghtLabirinto];  
		//creaStanze();
	}
	
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

	public void setStanzaIniziale(Stanza stanzaIniziale) {
		if(!StanzaInLabirinto(stanzaIniziale)) 
			addStanza(stanzaIniziale);
		StanzaIniziale = stanzaIniziale;
	}
	
	public void unsafeSetStanzaIniziale(Stanza stanzaIniziale) {
		StanzaIniziale = stanzaIniziale;
	}

	public Stanza getStanzaFinale() {
		return StanzaFinale;
	}

	public void setStanzaFinale(Stanza stanzaFinale) {
		if(!StanzaInLabirinto(stanzaFinale)) 
			addStanza(stanzaFinale);
		StanzaFinale = stanzaFinale;
	}
	
	public void unsafeSetStanzaFinale(Stanza stanzaFinale) {
		StanzaFinale = stanzaFinale;
	}

	public Stanza getStanzaAttuale() {
		return StanzaAttuale;
	}

	public void setStanzaAttuale(Stanza stanzaAttuale) {
		if(stanzaAttuale != null)
			StanzaAttuale = stanzaAttuale;
	}

	public Stanza[] getStanze() {
		return Stanze;
	}

	public void addStanza(Stanza stanza) {
		if(this.getStanze().length >= Labirinto.MaxLenghtLabirinto-1)
			setNewSize(1);
		this.Stanze[this.getStanze().length-1] = stanza;
	}
	
	// Increse Stanze in RunTime
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
