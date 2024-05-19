package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

//import it.uniroma3.diadia.ambienti.*;

public class LabirintoBuilder {

	Labirinto labirinto;
	Stanza ultimaAggiunta;

	
	public LabirintoBuilder() {
		this.labirinto= new Labirinto();
		this.ultimaAggiunta= null;
	}
	
	public LabirintoBuilder(Labirinto labirinto){
		this.labirinto = labirinto;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public LabirintoBuilder addStanzaIniziale(String stanza) {
		Stanza s=this.labirinto.cercaStanzaInLabirinto(stanza);
		if(s==null) {
			s=new Stanza(stanza);
		}
		this.labirinto.setStanzaIniziale(s);
		this.ultimaAggiunta=s;
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String stanza){
		Stanza s=this.labirinto.cercaStanzaInLabirinto(stanza);
		if(s==null) {
			s=new Stanza(stanza);
		}
		this.labirinto.setStanzaFinale(s);
		this.ultimaAggiunta=s;
		return this;
	}

	public LabirintoBuilder addAdiacenza(String stanza, String adiac, String direzione){
	/*	Stanza Attuale = null;
		Stanza Finale = null;
		for(Stanza a : this.labirinto.getStanze()){

			if(a.getNome().equals(stanza)){
				Attuale = a;
			}
			if(a.getNome().equals(adiac))
				Finale = a;
		}
		if(Attuale == null){
			Attuale = new Stanza(stanza);
			this.labirinto.addStanza(Attuale);
		}

		if(Finale == null){
			Finale = new Stanza(adiac);
			this.labirinto.addStanza(Finale);
		}

		Attuale.impostaStanzaAdiacente(direzione, Finale);
	*/
		
		Stanza corrente=this.labirinto.cercaStanzaInLabirinto(stanza);
		Stanza adiacente= this.labirinto.cercaStanzaInLabirinto(adiac);
		
		if(corrente==null) {
			corrente= new Stanza(stanza);
			this.labirinto.addStanza(corrente);
		}
		
		if(adiacente==null) {
			adiacente= new Stanza(adiac);
			this.labirinto.addStanza(adiacente);
		}
		
		corrente.impostaStanzaAdiacente(direzione, adiacente);
		this.ultimaAggiunta=adiacente;
		return this;
	}
	
	
	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
	/*assumere che non possano esistere due attrezzi con lo stesso
	 * nome in stanze dello stesso labirinto	
	 */
		if(this.ultimaAggiunta!=null) {
			Attrezzo a= ultimaAggiunta.getAttrezzo(attrezzo);
			if(a==null)
				a= new Attrezzo(attrezzo, peso);
			
			ultimaAggiunta.addAttrezzo(a);
		}
		
		return this;
	}


}
