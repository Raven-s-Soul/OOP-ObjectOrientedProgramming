package it.uniroma3.diadia.ambienti;

//import it.uniroma3.diadia.ambienti.*;

public class LabirintoBuilder {

    Labirinto Labirinto;

public LabirintoBuilder(Labirinto labirinto){
    this.Labirinto = labirinto;
}

public Labirinto addStanzaIniziale(String stanza) {
    Stanza s=new Stanza(stanza);
    this.Labirinto.setStanzaIniziale(s);
    return this.Labirinto;
}

public Labirinto addStanzaVincente(String stanza){
    Stanza s=new Stanza(stanza);
    this.Labirinto.setStanzaFinale(s);
    return this.Labirinto;

}

public Labirinto addAdiacenza(String stanza, String adiac, String direzione){
    Stanza Attuale = null;
    Stanza Finale = null;
    for(Stanza a : this.Labirinto.getStanze()){
        
        if(a.getNome().equals(stanza)){
            Attuale = a;
        }
        if(a.getNome().equals(adiac))
            Finale = a;
    }
    if(Attuale == null){
        Attuale = new Stanza(stanza);
        this.Labirinto.addStanza(Attuale);
    }
        
    if(Finale == null){
        Finale = new Stanza(adiac);
        this.Labirinto.addStanza(Finale);
    }
        
    Attuale.impostaStanzaAdiacente(direzione, Finale);
    
    return this.Labirinto;

}


}
