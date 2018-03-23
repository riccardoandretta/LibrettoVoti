package it.polito.tdp.libretto;

import java.util.Collections;

public class TestLibretto {

	public static void main(String[] args) {

		Libretto lib = new Libretto();

		lib.add(new Voto("Analisi", 30));
		lib.add(new Voto("Chimica", 28));
		lib.add(new Voto("TdP", 25));
		lib.add(new Voto("Fisica", 18));

		lib.stampa();
		// System.out.println(lib.toString());

		System.out.println("Voti uguali a 25");
		lib.stampa25();

		System.out.println("TdP voto:");
		System.out.println(lib.getMarkFromClass("TdP"));

		lib.add(new Voto("TdP", 25));
		lib.add(new Voto("TdP", 27));

		System.out.println(lib.toString());
		System.out.println("\n\n ******LIBRETTO INTELLIGENTE*****\n");

		Libretto newLib = new Libretto(lib.getVoti());

		System.out.println(newLib.toString());

		newLib.alzaVoti();
		System.out.println("Vecchio libretto");
		System.out.println(lib.toString());
		System.out.println("Nuovo libretto");
		System.out.println(newLib.toString());

		Collections.sort(newLib.getVoti());
		System.out.println("Libretto ordinato per nome");
		System.out.println(newLib.toString());

		Collections.sort(newLib.getVoti(), new ComparatorVoto());

		// Oppure senza creare la classe:
		// Collections.sort(newLib.getVoti(), new Comparator<Voto>() {
			// 	@Override
			// 	public int compare(Voto v1, Voto v2) {
			// 	return -(v1.getVoto() - v2.getVoto());
			// 	}
		// });
		
		System.out.println("Libretto ordinato per voto");
		System.out.println(newLib.toString());
	}

}
