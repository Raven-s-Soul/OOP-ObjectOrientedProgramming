package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

    private final String direzioneBloccata;
    private final String attrezzoSblocca;

    
    public StanzaBloccata(String nome, String direzione, String nomeAttrezzo) {
        super(nome);
        this.direzioneBloccata = direzione;
        this.attrezzoSblocca = nomeAttrezzo;
    }

    @Override
    public Stanza getStanzaAdiacente(String direzione) {
        /*if (this.getAttrezzi().contains(this.getAttrezzo(attrezzoSblocca))) {

            if (this.getStanzeAdiacenti().containsKey(direzione))
                return this.getStanzeAdiacenti().get(direzione);
        }*/
    	
    	if(this.getAttrezzi().containsKey(this.attrezzoSblocca)) {
    		if(this.getStanzeAdiacenti().containsKey(direzione))
    			return super.getStanzaAdiacente(direzione);		//da vedere! Override...
    	}

        return this;

    }


    @Override
    public String getDescrizione() {
        String bloccata = "Stanza bloccata nella direzione: " + direzioneBloccata + "\nPrendi il " + attrezzoSblocca + " e posalo nella stanza";
        if (!this.hasAttrezzo(attrezzoSblocca))
            return bloccata;
        return super.getDescrizione();
    }


}
