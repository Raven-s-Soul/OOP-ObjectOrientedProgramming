package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
    
	private String nomeAttrezzo;
	
	@Override
    public String getNome() {
        return "prendi";
    }

    @Override
    public String getParametro() {
        return this.nomeAttrezzo;
    }
    
    /**
	 * Prende un attrezzo dal ambiente e lo inserisce nella borsa del giocatore.
	 *
	 * @param nomeAttrezzo è la stringa utile a cercare l'attrezzo
	 */
    @Override
    public void esegui(Partita partita) {
    	if(partita.getLabirinto().getStanzaAttuale().getNumAttrezzi() ==0) {
    		partita.getIo().mostraMessaggio("Non sono presenti attrezzi nella stanza");
			return;
		}

		if(nomeAttrezzo==null){
			partita.getIo().mostraMessaggio("cosa vuoi prendere?");
		}
		else {
			Attrezzo attrezzoPreso= null;
			attrezzoPreso=partita.getLabirinto().getStanzaAttuale().getAttrezzo(nomeAttrezzo);  //prende l'attrezzo dalla stanza
			if(attrezzoPreso==null)
				partita.getIo().mostraMessaggio("oggetto non presente nella stanza");

			else {
				partita.getGiocatore().addAttrezzoToBorsa(attrezzoPreso);	//aggiunge l'attrezzo alla borsa
				partita.getLabirinto().getStanzaAttuale().removeAttrezzo(attrezzoPreso);	//rimuove da stanza
				partita.getIo().mostraMessaggio("Oggetto preso");
			}
		}

		partita.getIo().mostraMessaggio(partita.getLabirinto().getStanzaAttuale().getDescrizioneAttrezzi());

    }

    @Override
    public void setParametro(String parametro) {
    	this.nomeAttrezzo = parametro;
    }
}
