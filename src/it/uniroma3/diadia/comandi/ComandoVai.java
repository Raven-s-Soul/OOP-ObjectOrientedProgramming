package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

    private String direzione;

    @Override
    public String getNome() {
        return null;
    }

    @Override
    public String getParametro() {
        return null;
    }

    @Override
    public void esegui(Partita partita) {

        Stanza stanzaCorrente = partita.getLabirinto().getStanzaAttuale();

        if (direzione==null) {
            System.out.println("Dove vuoi andare? Devi specificare una direzione");
            return;
        }

        Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);

        if (prossimaStanza==null) {
            System.out.println("Direzione inesistente");
            return;
        }

        partita.getLabirinto().setStanzaAttuale(prossimaStanza);
        System.out.println(partita.getLabirinto().getStanzaAttuale().getNome());
        partita.getGiocatore().setCfu (partita.getGiocatore().getCfu()-1);

    }

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }
}
