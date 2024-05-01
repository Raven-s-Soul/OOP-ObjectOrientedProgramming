package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

    IO io;
    private String nomeAttrezzo;

    @Override
    public String getNome() {
        return "posa";
    }

    @Override
    public String getParametro() {
        return this.nomeAttrezzo;
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }

    /**
     * Posa un attrezzo dalla borsa del giocatore e lo inserisce nel ambiente.
     */
    @Override
    public void esegui(Partita partita) {
        if (partita.getGiocatore().getBorsa().getNumAttrezzi() == 0) {
            io.mostraMessaggio("Non sono presenti oggetti nella borsa.");
            return;
        }

        if (nomeAttrezzo == null) {
            io.mostraMessaggio("Cosa vuoi posare?");
        } else {
            Attrezzo attrezzoDaPosare = null;
            attrezzoDaPosare = partita.getGiocatore().removeAttrezzoDaBorsa(nomeAttrezzo);        //rimuouve attrezzo
            if (attrezzoDaPosare == null) {
                io.mostraMessaggio("Attrezzo non presente nella borsa.");
            } else {
                partita.getLabirinto().getStanzaAttuale().addAttrezzo(attrezzoDaPosare);    //aggiunge l'attrezzo alla stanza
                io.mostraMessaggio("Oggetto posato.");
            }
        }
        io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
    }

    @Override
    public void setIO(IO io) {
        this.io = io;
    }
}
