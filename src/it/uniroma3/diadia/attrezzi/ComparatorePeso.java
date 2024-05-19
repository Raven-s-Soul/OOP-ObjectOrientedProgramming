package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatorePeso implements Comparator<Attrezzo> {

    @Override
    public int compare(Attrezzo o1, Attrezzo o2) {
        int a  = Integer.compare(o1.getPeso(), o2.getPeso());
        if(a == 0){
           a = o1.getNome().compareTo(o2.getNome());
        }
        return a;
    }
}
