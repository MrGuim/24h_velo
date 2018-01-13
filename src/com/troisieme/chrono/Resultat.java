package com.troisieme.chrono;

import java.util.Vector;

public class Resultat implements Comparable{

	private Coureur coureur;
	private Temps temps;
	
	public Resultat(){
		this.temps = null;
		this.coureur = null;
	}
	
	public Resultat(Coureur c) {
		this.coureur = c;
		this.temps = null;
	}

	public Resultat(Coureur c, Temps t) {
		this.coureur = c;
		this.temps = t;
	}
	
	public void setCoureur(Coureur coureur){
		this.coureur = coureur;
	}
	public void setTemps(Temps temps){
		this.temps = temps;
	}

	public Coureur getCoureur() {
		return this.coureur;
	}

	public Temps getTemps() {
		return this.temps;
	}

	@Override
	public int compareTo(Object other) {
		if (other == null) {
			throw new IllegalArgumentException("comparaison a null");
		} else if (other == this) {
			return 0;
		} else if (other instanceof Resultat){
			Resultat resultat = (Resultat) other;
			return this.temps.compareTo(resultat.temps);
		} else {
			throw new IllegalArgumentException("comparaison illegale");
		}
	}
	
	@Override
	public String toString() {
		return String.format("%30s : %s", coureur.getNom(), temps);
	}
	
	public Vector<String> toVector(){
		Vector<String> table = new Vector();
		table.add(this.coureur.getNom());
		if(this.temps == null)
			table.add(null);
		else
			table.add(this.temps.toString());
		return table;
	}

}
