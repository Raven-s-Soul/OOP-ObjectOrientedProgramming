package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
    IO io;

    @Override
    public String getNome() {
        return "Guarda";
    }

    @Override
    public String getParametro() {
        return null;
    }

    @Override
    public void setParametro(String parametro) {

    }

    @Override
    public void esegui(Partita partita) {
        io.mostraMessaggio("Cfu: " + partita.getGiocatore().getCfu());
        io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
        io.mostraMessaggio(partita.getLabirinto().getStanzaAttuale().getDescrizione());

    }

    @Override
    public void setIO(IO io) {
        this.io = io;
    }
}
