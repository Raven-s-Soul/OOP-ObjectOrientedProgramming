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


        Stanza stanza = null;

        for (int i = 0; i < this.getNumAttrezzi(); i++) {
            if (this.getAttrezzi()[i].getNome().equals(this.attrezzoSblocca)) {
                for (int j = 0; j < this.getNumStanzeAdiacenti(); j++) {
                    if (this.getDirezioni()[j].equals(direzione))
                        stanza = this.getStanzeAdiacenti()[j];
                }
            }
        }

        if (stanza == null)
            return this;
        else
            return stanza;
    }


    @Override
    public String getDescrizione() {
    	  String bloccata = "Stanza bloccata nella direzione: "+ direzioneBloccata+"\nPrendi il " + attrezzoSblocca + " e posalo nella stanza";
    	  if(!this.hasAttrezzo(attrezzoSblocca))
    	    return bloccata;
    	  return super.getDescrizione();
    }


}
