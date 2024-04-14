package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
* Questa classe si occupa di gestire gli strumenti in possesso del giocatore.
* Inoltre gestisce anche il peso trasportabile degli stessi oggetti.
*
* @author Rita Tiani
* @see Attrezzo
* @version 1.0
*/
public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	/**
	* Crea Borsa, definendo pesoMax, attrezzi e numeroAttrezzi.
	*
	* @param pesoMax definisce il peso massimo contenibile dalla borsa.
	*/
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; 
		this.numeroAttrezzi = 0;
	}
	
	/**
	* Crea Borsa, richiamando il costruttore con paramentro DEFAULT_PESO_MAX_BORSA
	*/
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	/**
	* Aggiungere un attrezzo alla borsa.
	*
	* @param attrezzo è l'attrezzo da inserire.
	* @return booleano conferma inserimento attrezzo.
	*/
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;

		for(int i=0; i<this.attrezzi.length; i++) {
			if(attrezzi[i]==null) {
				this.attrezzi[i] = attrezzo;
				this.numeroAttrezzi++;
				return true;
			}
		}
		return false;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	/**
	* Cerca un attrezzo e ritorna il suo indirizzo.
	*
	* @param nomeAttrezzo ovvero la stringa col nome del attrezzo.
	* @return a un attrezzo trovato.
	*/
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.attrezzi.length; i++)
			if (this.attrezzi[i]!=null && this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}
	
	public Attrezzo[] getAttrezzi() {
		return this.attrezzi;
	}

	/**
	* Ritorna il peso della borsa formato da tutti gli elementi inseriti.
	*
	* @return peso ovvero intero che descrive il peso della borsa.
	*/
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.attrezzi.length; i++)
			if(this.attrezzi[i]!=null) 
				peso += this.attrezzi[i].getPeso();
		return peso;
	}
	
	public int getNumAttrezzi() {
		return this.numeroAttrezzi;
	}
	
	/**
	* Controlla se la borsa è vuota.
	*
	* @return booleano ovvero true se non ci sono attrezi altrimenti false.
	*/
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	/**
	* Controlla se è presento l'elemento in borsa.
	*
	* @param nomeAttrezzo, stringa che identifica l'attrezzo
	* @return booleano ovvero true se è presente altrimenti false.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/**
	* Rimuove l'elemento dalla borsa.
	*
	* @param nomeAttrezzo ovvero stringa contente il nome del attrezzo.
	* @return Attrezzo rimosso altrimenti null.
	*/
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		int i=0;
		for(Attrezzo attrezzo: this.attrezzi) {
			
			if(attrezzo!=null && attrezzo.getNome().equals(nomeAttrezzo)) {
				a= attrezzo;
				attrezzi[i]=null;
				this.numeroAttrezzi--;
			}
			i++;
		}
		
		return a;
	}
	
	/**
	* Crea e restituisce la stringa che elenca gli elementi in borsa.
	*
	* @return stringa contente gli elementi.
	*/
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.attrezzi.length; i++)
				if(attrezzi[i]!=null)
					s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}


}
