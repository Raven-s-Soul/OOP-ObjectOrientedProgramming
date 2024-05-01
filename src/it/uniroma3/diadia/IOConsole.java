package it.uniroma3.diadia;

import java.util.Scanner;

/**
* Questa classe si occupa di gestire l'input e output
* su console.
*
* @author docente di POO
* @version 1.0
*/
public class IOConsole implements  IO{

	/**
	* Scrive messaggi in output.
	*
	* @param msg ovvero la stringa da mostrare in output.
	*/
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}

	/**
	* Legge i messaggi in input da parte del giocatore.
	*
	* @return riga ovvero la stringa letta dalla tastiera.
	*/
	public String leggiRiga() {
		@SuppressWarnings("resource")
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}

}
