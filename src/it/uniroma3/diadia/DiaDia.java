package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 * <p>
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO (da un'idea di Michael Kolling and David J. Barnes)
 * @version 1.0
 * @see Partita
 * @see IOConsole
 */
public class DiaDia {

    static final private String MESSAGGIO_BENVENUTO = "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
            + "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
            + "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
            + "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
            + "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
            + "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
            + "Per conoscere le istruzioni usa il comando 'aiuto'.";

    private final Partita partita;
    private final IO io;

    /**
     * Crea DiaDia, e definisce partita.
     */
    public DiaDia(Labirinto labirinto, IO io) {
        this.io = io;
        this.partita = new Partita(labirinto);
    }
    
    public static void main(String[] argc) {
        /*IO io = new IOConsole();
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();*/

        IO io = new IOConsole();
        Labirinto labirinto = new LabirintoBuilder().addStanzaIniziale("LabCampusOne").addStanzaVincente("Biblioteca").addAdiacenza("LabCampusOne","Biblioteca","ovest").getLabirinto();
        DiaDia gioco = new DiaDia(labirinto, io);
        gioco.gioca();


    }

    /**
     * Iteratore di DiaDia, legge input dal giocatore
     * e li manda a analizzare.
     */
    public void gioca() {
        String istruzione;
        io.mostraMessaggio(MESSAGGIO_BENVENUTO);
        do
            istruzione = io.leggiRiga();
        while (!processaIstruzione(istruzione));
    }

    /**
     * Processa una istruzione
     *
     * @param istruzione ovvero una stringa contenente il comando da eseguire
     * @return true se l'istruzione e' eseguita e il gioco continua, false
     * altrimenti
     */
    private boolean processaIstruzione(String istruzione) {
        Comando comandoDaEseguire;
        FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
        comandoDaEseguire = factory.costruisciComando(istruzione, io);
        comandoDaEseguire.esegui(this.partita);
        if (this.partita.vinta()) {
            io.mostraMessaggio("Hai vinto!");
            this.partita.setFinita();
        }

        if (this.partita.isCfuFiniti()) // giocatoreIsVivo() capire...
            io.mostraMessaggio("Hai esaurito i CFU...");

        return this.partita.isFinita();

    }
}