package it.uniroma3.diadia.comandi;

public interface FabbricaDiComandi {

    /**
     * Crea un comando
     *
     * @param istruzione è la stringa che contiene nome e parametro.
     */
    Comando costruisciComando(String istruzione);
}
