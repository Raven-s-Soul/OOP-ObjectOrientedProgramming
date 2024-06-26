package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo. Una stanza e' un luogo
 * fisico nel gioco. E' collegata ad altre stanze attraverso delle uscite. Ogni
 * uscita e' associata ad una direzione.
 *
 * @author docente di POO
 * @version 1.0
 * @see Attrezzo
 */
public class StanzaProtected {

	//static final protected int NUMERO_MASSIMO_DIREZIONI = 4;
	static final protected int NUMERO_MASSIMO_ATTREZZI = 10;
	private final String nome;
	protected int numeroAttrezzi;
	protected int numeroStanzeAdiacenti;
	protected final Map<String, Attrezzo> attrezzi;
	protected final Map<String, Stanza> stanzeAdiacenti;

	/*protected Stanza[] stanzeAdiacenti;

    protected String[] direzioni;
      protected Attrezzo[] attrezzi;*/

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 *
	 * @param nome il nome della stanza
	 */
	public StanzaProtected(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.stanzeAdiacenti = new HashMap<String, Stanza>();
		this.attrezzi= new HashMap<String, Attrezzo>();    }

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza    stanza adiacente nella direzione indicata dal primo
	 *                  parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		/* boolean aggiornato = false;
        for (int i = 0; i < this.direzioni.length; i++)
            if (direzione.equals(this.direzioni[i])) {
                this.stanzeAdiacenti[i] = stanza;
                aggiornato = true;
            }
        if (!aggiornato)
            if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
                this.direzioni[numeroStanzeAdiacenti] = direzione;
                this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
                this.numeroStanzeAdiacenti++;
            }*/

		
		if(! this.stanzeAdiacenti.containsKey(direzione)) {
			this.stanzeAdiacenti.put(direzione, stanza);
			this.numeroStanzeAdiacenti++;
		}
		
		}

		/**
		 * Restituisce la stanza adiacente nella direzione specificata
		 *
		 * @param direzione
		 * @return oggetto Stanza, rappresenta la stanza adiacente
		 */
		public Stanza getStanzaAdiacente(String direzione) {
			/*Stanza stanza = null;
			for (int i = 0; i < this.numeroStanzeAdiacenti; i++)
				if (this.direzioni[i].equals(direzione))
					stanza = this.stanzeAdiacenti[i];
			return stanza;*/
			return this.stanzeAdiacenti.get(direzione);		}

		/**
		 * Restituisce la nome della stanza.
		 *
		 * @return il nome della stanza
		 */
		public String getNome() {
			return this.nome;
		}

		/**
		 * Restituisce la descrizione della stanza.
		 *
		 * @return la descrizione della stanza
		 */
		public String getDescrizione() {
			return this.toString();
		}


		public String getDescrizioneAttrezzi() {
			/*StringBuilder risultato = new StringBuilder();
			risultato.append("Attrezzi nella stanza: ");
			for (Attrezzo attrezzo : this.attrezzi) {
				if (attrezzo != null)
					risultato.append(attrezzo + " ");
			}
			return risultato.toString();*/

			StringBuilder risultato = new StringBuilder();
			risultato.append("Attrezzi nella stanza: ");
			for (Attrezzo attrezzo : this.attrezzi.values()) {
				if (attrezzo != null)
					risultato.append(attrezzo + " ");
			}

			return risultato.toString();
		}

		/**
		 * Restituisce la collezione di attrezzi presenti nella stanza.
		 *
		 * @return la collezione di attrezzi nella stanza.
		 */
		/*public Attrezzo[] getAttrezzi() {
			return this.attrezzi;
		}*/
		 public Map<String, Attrezzo> getAttrezzi() {
		        return this.attrezzi;
		 }
		   

		/**
		 * Mette un attrezzo nella stanza.
		 *
		 * @param attrezzo l'attrezzo da mettere nella stanza.
		 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
		 */
		public boolean addAttrezzo(Attrezzo attrezzo) {
			/*			if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {

				for (int i = 0; i < this.attrezzi.length; i++) {
					if (attrezzi[i] == null) {
						this.attrezzi[i] = attrezzo;
						this.numeroAttrezzi++;
						return true;
					}
				}
			}
			return false;*/

			if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {

				if(!this.attrezzi.containsKey(attrezzo.getNome())) {
					this.attrezzi.put(attrezzo.getNome(), attrezzo);
					this.numeroAttrezzi++;
					return true;
				}
			}
			return false;

		}

		/**
		 * Restituisce una rappresentazione stringa di questa stanza, stampadone la
		 * descrizione, le uscite e gli eventuali attrezzi contenuti
		 *
		 * @return la rappresentazione stringa
		 */
		public String toString() {
		/*	StringBuilder risultato = new StringBuilder();
			risultato.append("Stanza corrente: " + this.nome);
			risultato.append("\nUscite: ");
			for (String direzione : this.direzioni)
				if (direzione != null)
					risultato.append(" " + direzione);
			risultato.append("\nAttrezzi nella stanza: ");
			for (Attrezzo attrezzo : this.attrezzi) {
				if (attrezzo != null)
					risultato.append(attrezzo + " ");
			}
			return risultato.toString();*/
			
		    StringBuilder risultato = new StringBuilder();
	        risultato.append("Stanza corrente: " + this.nome);
	        risultato.append("\nUscite: ");
	        for (String direzione : this.stanzeAdiacenti.keySet())
	            if (direzione != null)
	                risultato.append(" " + direzione);
	        risultato.append("\nAttrezzi nella stanza: ");
	     
	        for(String attrezzo: this.attrezzi.keySet()) {
	        	if(attrezzo!=null)
	        		risultato.append(attrezzo + " ");
	        }
	        return risultato.toString();	
			
		}

		/**
		 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
		 *
		 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
		 */
		public boolean hasAttrezzo(String nomeAttrezzo) {
		/*	boolean trovato;
			trovato = false;
			for (Attrezzo attrezzo : this.attrezzi) {
				if (attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo)) // attrezzo != null &&
				{
					trovato = true;
					break;
				}
			}
			return trovato;*/
			return this.attrezzi.containsKey(nomeAttrezzo);
		}

		/**
		 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
		 *
		 * @param nomeAttrezzo
		 * @return l'attrezzo presente nella stanza. null se l'attrezzo non e' presente.
		 */
		public Attrezzo getAttrezzo(String nomeAttrezzo) {
			/*Attrezzo attrezzoCercato;
			attrezzoCercato = null;
			for (Attrezzo attrezzo : this.attrezzi) {
				if (attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo))
					attrezzoCercato = attrezzo;
			}
			return attrezzoCercato;*/
			
			return this.attrezzi.get(nomeAttrezzo);
		}

		/**
		 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
		 *
		 * @param attrezzo
		 * @return true se l'attrezzo e' stato rimosso, false altrimenti
		 */
		public boolean removeAttrezzo(Attrezzo attrezzo) {
		/*	int i = 0;
			for (Attrezzo a : this.attrezzi) {

				if (a != null && a == attrezzo) {
					attrezzi[i] = null;
					this.numeroAttrezzi--;
					return true;
				}
				i++;
			}
			return false;*/
			
			Attrezzo a= this.attrezzi.remove(attrezzo.getNome());
	    	
	    	if(a!=null) {
	    		this.numeroAttrezzi--;
	    		return true;
	    	}
	    	
	    	return false;
		}

		/*public String[] getDirezioni() {
			String[] direzioni = new String[this.numeroStanzeAdiacenti];
			System.arraycopy(this.direzioni, 0, direzioni, 0, this.numeroStanzeAdiacenti);
			return direzioni;
		}*/
		public Set<String> getDirezioni() {
			return this.stanzeAdiacenti.keySet();
		}

		/*public Stanza[] getStanzeAdiacenti() {
			return this.stanzeAdiacenti;
		}*/
		public Map<String, Stanza> getStanzeAdiacenti() {
			return this.stanzeAdiacenti;
		}


		public int getMaxAttrezzi() {
			return NUMERO_MASSIMO_ATTREZZI;
		}

		/*public int getMaxDirezioni() {
			return NUMERO_MASSIMO_DIREZIONI;
		}*/

		public int getNumStanzeAdiacenti() {
			return this.numeroStanzeAdiacenti;
		}

		public int getNumAttrezzi() {
			return this.numeroAttrezzi;
		}

	}