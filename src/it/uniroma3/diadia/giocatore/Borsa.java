package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe si occupa di gestire gli strumenti in possesso del giocatore.
 * Inoltre gestisce anche il peso trasportabile degli stessi oggetti.
 *
 * @author Rita Tiani
 * @version 1.0
 * @see Attrezzo
 */
public class Borsa {
    public final static int DEFAULT_PESO_MAX_BORSA = 10;
    private List<Attrezzo> attrezzi;
    private final int pesoMax;
    private int numeroAttrezzi;

    /**
     * Crea Borsa, definendo pesoMax, attrezzi e numeroAttrezzi.
     *
     * @param pesoMax definisce il peso massimo contenibile dalla borsa.
     */
    public Borsa(int pesoMax) {
        this.pesoMax = pesoMax;
        this.attrezzi = new ArrayList<Attrezzo>();
        this.numeroAttrezzi = 0;
    }

    /**
     * Crea Borsa, richiamando il costruttore con paramentro DEFAULT_PESO_MAX_BORSA
     */
    public Borsa() {
        this(DEFAULT_PESO_MAX_BORSA);
    }

    /**
     * Aggiungere un attrezzo alla borsa.
     *
     * @param attrezzo è l'attrezzo da inserire.
     * @return booleano conferma inserimento attrezzo.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (attrezzo == null)
            return false;
        if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
            return false;
        this.attrezzi.addLast(attrezzo);
        this.numeroAttrezzi++;

        return true;
    }

    public int getPesoMax() {
        return pesoMax;
    }

    /**
     * Cerca un attrezzo e ritorna il suo indirizzo.
     *
     * @param nomeAttrezzo ovvero la stringa col nome del attrezzo.
     * @return a un attrezzo trovato.
     */
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        for (Attrezzo b : this.attrezzi ){
            if(b.getNome().equals(nomeAttrezzo))
                return b;
        }
        return null;
    }

    public List<Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Ritorna il peso della borsa formato da tutti gli elementi inseriti.
     *
     * @return peso ovvero intero che descrive il peso della borsa.
     */
    public int getPeso() {

        int peso = 0;
        if(numeroAttrezzi <= 0)
            return 0;
        for (Attrezzo a : this.attrezzi){
            if(a != null)
                peso = peso + a.getPeso();
        }

        return peso;
    }

    public int getNumAttrezzi() {
        return this.numeroAttrezzi;
    }

    /**
     * Controlla se la borsa è vuota.
     *
     * @return booleano ovvero true se non ci sono attrezi altrimenti false.
     */
    public boolean isEmpty() {
        return this.numeroAttrezzi == 0;
    }

    /**
     * Controlla se è presento l'elemento in borsa.
     *
     * @param nomeAttrezzo, stringa che identifica l'attrezzo
     * @return booleano ovvero true se è presente altrimenti false.
     */
    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.getAttrezzo(nomeAttrezzo) != null;
    }

    /**
     * Rimuove l'elemento dalla borsa.
     *
     * @param nomeAttrezzo ovvero stringa contente il nome del attrezzo.
     * @return Attrezzo rimosso altrimenti null.
     */
    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
        for(Attrezzo attrezzo : this.attrezzi){
            if(attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo)){
                this.attrezzi.remove(attrezzo);
                this.numeroAttrezzi--;
                return attrezzo;
            }
        }
        return null;
    }

    /**
     * Crea e restituisce la stringa che elenca gli elementi in borsa.
     *
     * @return stringa contente gli elementi.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (!this.isEmpty()) {
            s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
            for (Attrezzo a : this.attrezzi)
                if (a != null)
                    s.append(a.toString() + " ");
        } else
            s.append("Borsa vuota.");
        return s.toString();
    }
    
}
