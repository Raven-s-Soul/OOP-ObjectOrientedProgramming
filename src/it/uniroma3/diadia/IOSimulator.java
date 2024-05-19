package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {

    // public static final int baseArrayLength = 10;

    ArrayList<String> RigheIn;
    ArrayList<String> RigheGen;


    int indexRigheIn;
    int indexRigheOut;
    int indexGenOut;


    public IOSimulator(String[] Input) {
        this.RigheIn = new ArrayList<String>();
        this.RigheIn.addAll(List.of(Input));
        this.RigheGen = new ArrayList<String>();
        this.indexGenOut = 0;
        this.indexRigheIn = 0;
        this.indexRigheOut = 0;
    }

    @Override
    public void mostraMessaggio(String msg) {
        this.RigheGen.add(indexGenOut, msg);
        this.indexGenOut++;
    }

    @Override
    public String leggiRiga() {
        String riga = this.RigheIn.get(indexRigheIn);
        this.indexRigheIn++;
        return riga;
    }

    public String nextMessaggio() {
        String next = this.RigheGen.get(indexRigheOut);
        this.indexRigheOut++;
        return next;
    }

    public boolean hasNextMessaggio() {
        return this.indexRigheOut < this.indexGenOut;
    }
}
