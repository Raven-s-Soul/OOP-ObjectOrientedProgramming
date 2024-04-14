package it.uniroma3.diadia;

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
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
		
	/*aggiunge l'attrezzo alla borsa*/
	public void addAttrezzoToBorsa(Attrezzo aggiungere) {
		this.borsa.addAttrezzo(aggiungere);
	}
	
	public Attrezzo removeAttrezzoDaBorsa(String nomeAttrezzo) {
		return this.getBorsa().removeAttrezzo(nomeAttrezzo);
	}
	
	
	
	/*ritorna l'attrezzo preso da borsa*/
	public Attrezzo getAttrezzoDaBorsa(String nomeAttrezzo) {
		return this.borsa.getAttrezzo(nomeAttrezzo);
	}

	
	
}
