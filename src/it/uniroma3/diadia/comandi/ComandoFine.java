package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
    @Override
    public String getNome() {
        return "fine";
    }

    @Override
    public String getParametro() {
        return null;
    }
    
    /**
	 * Comando "Fine".
	 */
    @Override
    public void esegui(Partita partita) {
    	// si desidera smettere
    	partita.getIo().mostraMessaggio("Grazie di aver giocato!");
    	partita.setFinita();
    }

    @Override
    public void setParametro(String parametro) {

    }
}
