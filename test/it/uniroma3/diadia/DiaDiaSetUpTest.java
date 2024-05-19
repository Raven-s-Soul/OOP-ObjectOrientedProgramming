package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

public class DiaDiaSetUpTest {

    static DiaDia DiaDia;

    public static IOSimulator Simulatore(String[] comandi) {
        IOSimulator io = new IOSimulator(comandi);
        DiaDia = new DiaDia( new LabirintoBuilder().getLabirinto(), io);
        DiaDia.gioca();
        return io;
    }

    public static IOSimulator Simulatore(String[] comandi,Labirinto Labirinto ) {
        IOSimulator io = new IOSimulator(comandi);
        DiaDia = new DiaDia( Labirinto, io);
        DiaDia.gioca();
        return io;
    }

    public static Labirinto exLabirinto(){
        LabirintoBuilder Builder = new LabirintoBuilder();
        Builder.addStanzaIniziale("Inizio");
        Builder.addAdiacenza("Inizio", "Finale", "nord");
        Builder.getLabirinto().setStanzaAttuale(Builder.getLabirinto().getStanzaIniziale());
        return Builder.getLabirinto();
    }

}
