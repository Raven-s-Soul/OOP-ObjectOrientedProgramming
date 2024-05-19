package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.LabirintoBuilder;

public class DiaDiaSetUpTest {

    public static IOSimulator Simulatore(String[] comandi) {
        IOSimulator io = new IOSimulator(comandi);
        new DiaDia( new LabirintoBuilder().getLabirinto(), io).gioca();
        return io;
    }

}
