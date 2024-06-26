package it.uniroma3.diadia.attrezzi;

/**
 * Una semplice classe che modella un attrezzo. Gli attrezzi possono trovarsi
 * all'interno delle stanze del labirinto. Ogni attrezzo ha un nome ed un peso.
 *
 * @author docente di POO
 * @version 1.0
 */
public class Attrezzo implements Comparable<Attrezzo>{

    private final String nome;
    private final int peso;

    /**
     * Crea un attrezzo
     *
     * @param nome il nome che identifica l'attrezzo
     * @param peso il peso dell'attrezzo
     */
    public Attrezzo(String nome, int peso) {
        this.peso = peso;
        this.nome = nome;
    }

    /**
     * Restituisce il nome identificatore dell'attrezzo
     *
     * @return il nome identificatore dell'attrezzo
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce il peso dell'attrezzo
     *
     * @return il peso dell'attrezzo
     */
    public int getPeso() {
        return this.peso;
    }

    /**
     * Restituisce una rappresentazione stringa di questo attrezzo
     *
     * @return la rappresentazione stringa
     */
    public String toString() {
        return this.getNome() + " (" + this.getPeso() + "kg)";
    }

    @Override
    public int hashCode(){
        return this.getClass().hashCode()+this.getNome().hashCode()+this.getPeso();
    }

    @Override
    public boolean equals(Object E){
        if(E==null || E.getClass() != this.getClass()) return false;
        Attrezzo F = (Attrezzo) E;
        return this.getNome().equals(F.getNome()) && this.getPeso() == F.getPeso();
    }

    @Override
    public int compareTo(Attrezzo o) {
        return this.getNome().compareTo(o.getNome());
    }
}