package it.polito.tdp.libretto;

import java.util.*;

public class Libretto{

	private List<Voto> voti; // non ho ancora creato un oggetto (se non l'oggetto stesso della lista)

	public Libretto() {
		this.voti = new ArrayList<>(); // anche mettendo solo <> Java capisce che intendo Voto !!!
	}

	public Libretto(List<Voto> voti) {
		// #1
		// this.voti = voti; // così copio l'indirizzo di memoria, ovvero il riferimento
		// > entrambi i libretti puntano a quella lista
		// #2
		// this.voti = new ArrayList<>(voti); // ho due oggetti diversi, e le modifiche
		// ad uno non influenzano l'altro
		// ma non risolve ancora il problema, che è rappresentato dagli oggetti
		// all'interno della lista, che non sono stati ancora duplicati

		// #3
		// this.voti = new ArrayList<>();
		// for (Voto v : voti) {
		// this.voti.add(v);
		// } // fa la stessa cosa di prima

		// DEEP COPY
		this.voti = new ArrayList<>();
		for (Voto v : voti) {
			this.voti.add(new Voto(v.getEsame(), v.getVoto())); // creo nuovi oggetti, posso operare separatamente sui due libretti
		}
	}

	public void add(Voto v) {
		if (this.voti.contains(v)) {
			System.out.println("Il voto esiste già");
			return;
		}
		for (Voto voto : this.voti) {
			if (voto.getEsame().equals(v.getEsame())) {
				System.out.println("Trovato lo stesso esame (aggiorno il voto)");
				voto.setVoto(v.getVoto());
				return;
			}
		}

		this.voti.add(v);
	}

	public void stampa() {
		System.out.println("Ci sono " + voti.size() + " voti");
		for (Voto v : this.voti) {
			System.out.println(v);
		}
	}

	public void stampa25() {
		for (Voto v : this.voti) {
			if (v.getVoto() == 25) {
				System.out.println(v);
			}
		}

	}

	// meglio l'override di toString piuttosto che il metodo stampa()
	public String toString() {

		StringBuilder sb = new StringBuilder(); // ha il metodo append()

		// la differenza sta nel fatto che le stringhe sono statiche in java, quindi
		// concatenarle significa creare ogni volta una nuova stringa
		// computazionalmente è più efficiente creare l'oggetto

		sb.append("Ci sono " + voti.size() + " voti\n");
		for (Voto v : this.voti) {
			sb.append(v.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	public String getMarkFromClass(String nomeCorso) {

		for (Voto v : this.voti) {
			if (v.getEsame().toLowerCase().equals(nomeCorso.toLowerCase())) { // non usare mai ==
				// è l'equals di String quindi è già ridefinito, se avessi un altro tipo di
				// oggetto lo dovrei ridefinire (perchè sarebbe quello di Object)
				return String.valueOf(v.getVoto());
			}
		}
		return "nomeCorso not found";

	}

	public List<Voto> getVoti() {
		return this.voti;
	}

	public void alzaVoti() {

		for (Voto v : this.voti) {
			if (v.getVoto() >= 24) {
				v.setVoto(v.getVoto() + 2);
			} else if (v.getVoto() >= 18) {
				v.setVoto(v.getVoto() + 1);
			}
		}

	}


}
