package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;


/**
 * Questa classe modella un comando. Un comando consiste in piu' due parole:
 * il nome del comando ed un parametro su cui si applica il comando. (Ad es.
 * alla riga digitata dall'utente "vai nord" corrisponde un comando di nome
 * "vai" e parametro "nord").
 *
 * @author docente di POO
 * @version 1.0
 */
public interface Comando {
    String getNome();

    String getParametro();

    void setParametro(String parametro);

    void esegui(Partita partita);

}
