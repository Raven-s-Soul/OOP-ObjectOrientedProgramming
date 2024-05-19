package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

    private final String attrezzoVedere;

    public StanzaBuia(String nome, String attrezzo) {
        super(nome);
        this.attrezzoVedere = attrezzo;
    }

    @Override
    public String getDescrizione() {
    	//nell'if: this.getAttrezzi().contains(this.getAttrezzo(this.attrezzoVedere))
        if(this.getAttrezzi().containsKey(this.attrezzoVedere))
            return super.getDescrizione();

        return "qui c'è buio pesto!";
    }
}
