package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
* Questa classe si occupa di gestire i cfu e l'accesso alla borsa.
*
* @author Rita Tiani
* @see Borsa
* @version 1.0
*/
public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
	/**
	* Crea Giocatore definendo cfu al valore 
	* standard e definendo borsa.
	*/
	public Giocatore() {
		this.cfu= CFU_INIZIALI;
		this.borsa= new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
		
	public Borsa getBorsa() {
		return this.borsa;
	}
		
	/**
	* Aggiunge un attrezzo alla borsa.
	*
	* @param aggiungere attrezzo da aggiungere.
	*/
	public void addAttrezzoToBorsa(Attrezzo aggiungere) {
		this.borsa.addAttrezzo(aggiungere);
	}
	
	/**
	* Rimuove un attrezzo dalla borsa.
	*
	* @param nomeAttrezzo ovvero stringa del oggetto da rimuovere.
	* @return Attrezzo rimosso.
	*/
	public Attrezzo removeAttrezzoDaBorsa(String nomeAttrezzo) {
		return this.getBorsa().removeAttrezzo(nomeAttrezzo);
	}
	
	
	

	
	
}
