package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

public interface FabbricaDiComandi {

    /**
     * Crea un comando
     *
     * @param istruzione è la stringa che contiene nome e parametro.
     * @param io
     */
    Comando costruisciComando(String istruzione, IO io);
}
