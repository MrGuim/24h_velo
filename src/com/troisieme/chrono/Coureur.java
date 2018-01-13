package com.troisieme.chrono;

public class Coureur {

	private String nom;
	
	public Coureur() {
	}

	public Coureur(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (o instanceof Coureur) {
			Coureur c = (Coureur) o;
			return this.nom.equals(c.getNom());
		} else {
			return false;
		}
	}
}
