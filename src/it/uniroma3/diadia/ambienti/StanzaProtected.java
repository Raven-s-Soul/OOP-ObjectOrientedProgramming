package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected extends Stanza{

    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     *
     * @param nome il nome della stanza
     */
    public StanzaProtected(String nome) {
        super(nome);
    }

    protected Attrezzo[] attrezzi;

    protected int numeroAttrezzi;
}
