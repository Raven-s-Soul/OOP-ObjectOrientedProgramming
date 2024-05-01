package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

    private String direzione;

    @Override
    public String getNome() {
        return "vai";
    }

    @Override
    public String getParametro() {
        return this.direzione;
    }
    
    /**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra e ne stampa il
	 * nome, altrimenti stampa un messaggio di errore
	 */
    @Override
    public void esegui(Partita partita) {
        if (direzione==null) {
        	partita.getIo().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
        }
        else {
        	Stanza stanzaCorrente = partita.getLabirinto().getStanzaAttuale();
            Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
            if (prossimaStanza==null) {
            	partita.getIo().mostraMessaggio("Direzione inesistente");
            }
            else {
            	partita.getLabirinto().setStanzaAttuale(prossimaStanza);
                //partita.getIo().mostraMessaggio(partita.getLabirinto().getStanzaAttuale().getNome());
                partita.getGiocatore().setCfu (partita.getGiocatore().getCfu()-1);
            }
        }
        partita.getIo().mostraMessaggio(partita.getLabirinto().getStanzaAttuale().getDescrizione());
    }

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }
}
