package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
    @Override
    public String getNome() {
        return "Guarda";
    }

    @Override
    public String getParametro() {
        return null;
    }

    @Override
    public void esegui(Partita partita) {
    	partita.getIo().mostraMessaggio("Cfu: " + partita.getGiocatore().getCfu());
    	partita.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
    	partita.getIo().mostraMessaggio(partita.getLabirinto().getStanzaAttuale().getDescrizione());
    	
    }

    @Override
    public void setParametro(String parametro) {

    }
}
