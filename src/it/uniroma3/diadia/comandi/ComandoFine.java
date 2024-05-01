package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

    IO io;

    @Override
    public String getNome() {
        return "fine";
    }

    @Override
    public String getParametro() {
        return null;
    }

    @Override
    public void setParametro(String parametro) {

    }

    /**
     * Comando "Fine".
     */
    @Override
    public void esegui(Partita partita) {
        // si desidera smettere
        io.mostraMessaggio("Grazie di aver giocato!");
        partita.setFinita();
    }

    @Override
    public void setIO(IO io) {
        this.io = io;
    }
}
