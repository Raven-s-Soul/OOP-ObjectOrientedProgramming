package it.uniroma3.diadia;

/**
 * Questa classe modella una partita del gioco
 *
 * @author docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;

	private Labirinto Labirinto;
	private boolean finita;
	private int cfu;

	public Partita() {
		this.Labirinto = new Labirinto();
		this.getLabirinto().creaStanze();
		this.finita = false;
		this.cfu = CFU_INIZIALI;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * 
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getLabirinto().getStanzaAttuale() == this.getLabirinto().getStanzaFinale();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * 
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (cfu == 0);
	}

	//Imposta la partita come finita
	public void setFinita() {
		this.finita = true;
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Labirinto getLabirinto() {
		return Labirinto;
	}
}
