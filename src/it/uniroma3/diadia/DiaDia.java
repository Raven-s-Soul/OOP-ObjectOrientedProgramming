package it.uniroma3.diadia;



import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO (da un'idea di Michael Kolling and David J. Barnes)
 * 
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa" };

	private Partita partita;
	private IOConsole io;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);

		do
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
		
	}

	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false
	 *         altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine();
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			io.mostraMessaggio("Comando sconosciuto");
		
		if (this.partita.isFinita()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		StringBuilder s= new StringBuilder();
		for (int i = 0; i < elencoComandi.length; i++) {
			s.append(elencoComandi[i] + " ");
		}
		io.mostraMessaggio(s.toString());
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra e ne stampa il
	 * nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if (direzione == null) {
			io.mostraMessaggio("Dove vuoi andare ?");
		}
		else {
			Stanza prossimaStanza = null;
			prossimaStanza = this.partita.getLabirinto().getStanzaAttuale().getStanzaAdiacente(direzione);
			if (prossimaStanza == null)
				io.mostraMessaggio("Direzione inesistente");
			else {
				this.partita.getLabirinto().setStanzaAttuale(prossimaStanza);
				int cfu = this.partita.getGiocatore().getCfu();
				this.partita.getGiocatore().setCfu(--cfu);
			}
		}
		io.mostraMessaggio(partita.getLabirinto().getStanzaAttuale().getDescrizione());	
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!"); // si desidera smettere
	}
	
	private void prendi(String nomeAttrezzo) {
		if(this.partita.getLabirinto().getStanzaAttuale().getNumAttrezzi() ==0) {
			io.mostraMessaggio("Non sono presenti attrezzi nella stanza");
			return;
		}
		
		if(nomeAttrezzo==null){
			io.mostraMessaggio("cosa vuoi prendere?");
		}
		else {
			Attrezzo attrezzoPreso= null;
			attrezzoPreso=this.partita.getLabirinto().getStanzaAttuale().getAttrezzo(nomeAttrezzo);  //prende l'attrezzo dalla stanza
			if(attrezzoPreso==null)
				io.mostraMessaggio("oggetto non presente nella stanza");

			else {
				this.partita.getGiocatore().addAttrezzoToBorsa(attrezzoPreso);	//aggiunge l'attrezzo alla borsa
				this.partita.getLabirinto().getStanzaAttuale().removeAttrezzo(attrezzoPreso);	//rimuove da stanza
				io.mostraMessaggio("Oggetto preso");
			}
		}
		
		io.mostraMessaggio(partita.getLabirinto().getStanzaAttuale().getDescrizioneAttrezzi());
	
	}
	
	private void posa (String nomeAttrezzo) {
		if(this.partita.getGiocatore().getBorsa().getNumAttrezzi()==0) {
			io.mostraMessaggio("Non sono presenti oggetti nella borsa");
			return;
		}
		
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("Cosa vuoi posare?");
		}
		else {
			Attrezzo attrezzoDaPosare= null;
			attrezzoDaPosare= this.partita.getGiocatore().removeAttrezzoDaBorsa(nomeAttrezzo);		//rimuouve attrezzo
			if(attrezzoDaPosare==null) {
				io.mostraMessaggio("Attrezzo non presente nella borsa");
			}
			else {
				this.partita.getLabirinto().getStanzaAttuale().addAttrezzo(attrezzoDaPosare);	//aggiunge l'attrezzo alla stanza
			}
		}
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.io=new IOConsole(); 
		gioco.gioca();
		
	}
}