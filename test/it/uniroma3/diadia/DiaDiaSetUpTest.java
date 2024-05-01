package it.uniroma3.diadia;

public class DiaDiaSetUpTest {

    public static IOSimulator Simulatore(String[] comandi) {
        IOSimulator io = new IOSimulator(comandi);
        new DiaDia(io).gioca();
        return io;
    }

}
