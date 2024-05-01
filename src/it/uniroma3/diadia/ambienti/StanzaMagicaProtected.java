package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{

    final static private int SOGLIA_MAGICA_DEFAULT = 3;
    private int contatoreAttrezziPosati;
    private int sogliaMagica;

    public StanzaMagicaProtected(String nome) {
        this(nome, SOGLIA_MAGICA_DEFAULT);
    }

    public StanzaMagicaProtected(String nome, int soglia) {
        super(nome);
        this.contatoreAttrezziPosati = 0;
        this.sogliaMagica = soglia;
    }

    /**
     * @return the contatoreAttrezziPosati
     */
    public int getContatoreAttrezziPosati() {
        return contatoreAttrezziPosati;
    }

    /**
     * @param contatoreAttrezziPosati the contatoreAttrezziPosati to set
     */
    public void setContatoreAttrezziPosati(int contatoreAttrezziPosati) {
        this.contatoreAttrezziPosati = contatoreAttrezziPosati;
    }

    /**
     * @return the sogliaMagica
     */
    public int getSogliaMagica() {
        return sogliaMagica;
    }

    /**
     * @param sogliaMagica the sogliaMagica to set
     */
    public void setSogliaMagica(int sogliaMagica) {
        this.sogliaMagica = sogliaMagica;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if(attrezzo == null) return false;
        contatoreAttrezziPosati++;
        if (this.contatoreAttrezziPosati>this.sogliaMagica) {
            attrezzo = this.modificaAttrezzo(attrezzo);
        }
        if (this.numeroAttrezzi<this.attrezzi.length) {
            this.attrezzi[this.numeroAttrezzi] = attrezzo;
            this.numeroAttrezzi++;
            return true;
        }
        else return false;
    }

    private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
        StringBuilder nomeInvertito;
        int pesoX2 = attrezzo.getPeso() * 2;
        nomeInvertito = new StringBuilder(attrezzo.getNome());
        nomeInvertito = nomeInvertito.reverse();
        attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
        return attrezzo;
    }
}
