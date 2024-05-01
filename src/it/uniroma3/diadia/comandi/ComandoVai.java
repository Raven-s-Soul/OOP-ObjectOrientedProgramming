package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

    IO io;
    private String direzione;

    @Override
    public String getNome() {
        return "vai";
    }

    @Override
    public String getParametro() {
        return this.direzione;
    }

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }

    /**
     * Cerca di andare in una direzione. Se c'e' una stanza ci entra e ne stampa il
     * nome, altrimenti stampa un messaggio di errore
     */
    @Override
    public void esegui(Partita partita) {
        if (direzione == null) {
            io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
        } else {
            Stanza stanzaCorrente = partita.getLabirinto().getStanzaAttuale();
            Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
            if (prossimaStanza == null) {
                io.mostraMessaggio("Direzione inesistente");
            } else {
                partita.getLabirinto().setStanzaAttuale(prossimaStanza);
                //partita.getIo().mostraMessaggio(partita.getLabirinto().getStanzaAttuale().getNome());
                partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
            }
        }
        io.mostraMessaggio(partita.getLabirinto().getStanzaAttuale().getDescrizione());
    }

    @Override
    public void setIO(IO io) {
        this.io = io;
    }
}
