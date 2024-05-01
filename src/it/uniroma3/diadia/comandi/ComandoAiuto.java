package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

    static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};

    @Override
    public String getNome() {
        return "aiuto";
    }

    @Override
    public String getParametro() {
        return null;
    }

    @Override
    public void setParametro(String parametro) {

    }

    /**
     * Stampa informazioni di aiuto.
     */
    @Override
    public void esegui(Partita partita) {
        StringBuilder s = new StringBuilder();
        for (String string : elencoComandi) {
            s.append(string + " ");
        }
        partita.getIo().mostraMessaggio(s.toString());
    }
}
