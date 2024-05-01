package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

    static final private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa", "Guarda" };

    @Override
    public String getNome() {
        return "aiuto";
    }

    @Override
    public String getParametro() {
        return null;
    }

    /**
     * Stampa informazioni di aiuto.
     */
    @Override
    public void esegui(Partita partita) {
        StringBuilder s= new StringBuilder();
        for (String string : elencoComandi) {
            s.append(string + " ");
        }
        partita.getIo().mostraMessaggio(s.toString());
    }

    @Override
    public void setParametro(String parametro) {

    }
}
