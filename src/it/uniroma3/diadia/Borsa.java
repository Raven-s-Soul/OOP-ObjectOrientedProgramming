package it.uniroma3.diadia;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;

		for(int i=0; i<this.attrezzi.length; i++) {
			if(attrezzi[i]==null) {
				this.attrezzi[i] = attrezzo;
				this.numeroAttrezzi++;
				return true;
			}
		}
		return false;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.attrezzi.length; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.attrezzi.length; i++)
			if(this.attrezzi[i]!=null) 
				peso += this.attrezzi[i].getPeso();
		return peso;
	}
	
	public int getNumAttrezzi() {
		return this.numeroAttrezzi;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/*creato da me*/
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		int i=0;
		for(Attrezzo attrezzo: this.attrezzi) {
			
			if(attrezzo!=null && attrezzo.getNome().equals(nomeAttrezzo)) {
				a= attrezzo;
				attrezzi[i]=null;
				this.numeroAttrezzi--;
			}
			i++;
		}
		
		return a;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.attrezzi.length; i++)
				if(attrezzi[i]!=null)
					s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}


}
