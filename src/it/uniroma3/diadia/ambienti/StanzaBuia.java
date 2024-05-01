package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{
	
	private String attrezzoVedere;
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoVedere= attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		
		for(Attrezzo a: this.getAttrezzi()) {
			if(a!=null && a.getNome().equals(attrezzoVedere))
				return super.getDescrizione();
		}
		
		return "qui c'è buio pesto!";		
	}
}
