package it.polito.tdp.libretto;

import java.util.Comparator;

public class ComparatorVoto implements Comparator<Voto> {

	@Override
	public int compare(Voto v1, Voto v2) {
		return -(v1.getVoto() - v2.getVoto());
	}

}
