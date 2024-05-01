package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

    IO io;
    private String nomeAttrezzo;

    @Override
    public String getNome() {
        return "prendi";
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
     * Prende un attrezzo dal ambiente e lo inserisce nella borsa del giocatore.
     */
    @Override
    public void esegui(Partita partita) {
        if (partita.getLabirinto().getStanzaAttuale().getNumAttrezzi() == 0) {
            io.mostraMessaggio("Non sono presenti attrezzi nella stanza");
            return;
        }

        if (nomeAttrezzo == null) {
            io.mostraMessaggio("cosa vuoi prendere?");
        } else {
            Attrezzo attrezzoPreso = null;
            attrezzoPreso = partita.getLabirinto().getStanzaAttuale().getAttrezzo(nomeAttrezzo);  //prende l'attrezzo dalla stanza
            if (attrezzoPreso == null)
                io.mostraMessaggio("oggetto non presente nella stanza");

            else {
                partita.getGiocatore().addAttrezzoToBorsa(attrezzoPreso);    //aggiunge l'attrezzo alla borsa
                partita.getLabirinto().getStanzaAttuale().removeAttrezzo(attrezzoPreso);    //rimuove da stanza
                io.mostraMessaggio("Oggetto preso");
            }
        }

        io.mostraMessaggio(partita.getLabirinto().getStanzaAttuale().getDescrizioneAttrezzi());

    }

    @Override
    public void setIO(IO io) {
        this.io = io;
    }
}
