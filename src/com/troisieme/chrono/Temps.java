package com.troisieme.chrono;

public class Temps implements Comparable {

	private int heures;
	private int minutes;
	private int secondes;

	private void normalise() {
		minutes = minutes + secondes / 60;
		secondes = secondes % 60;
		heures = heures + minutes / 60;
		minutes = minutes % 60;
	}

	public Temps(int h, int m, int s) {
		this.secondes = s;
		this.minutes = m;
		this.heures = h;

		normalise();
	}

	/**
	 * @pre -
	 * @post retourne le nombre d'heures.
	 */
	public int getH() {
		return this.heures;
	}

	/**
	 * @pre -
	 * @post retourne le nombre de minutes.
	 */
	public int getM() {
		return this.minutes;
	}

	/**
	 * @pre -
	 * @post retourne le nombre de secondes.
	 */
	public int getS() {
		return this.secondes;
	}

	public int secondes() {
		return (this.heures * 60 + this.minutes) * 60 + this.secondes;
	}


	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", heures, minutes, secondes);
	}


	@Override
	public int compareTo(Object o) {
		if (o == null) {
			throw new IllegalArgumentException("comparaison a null");
		} else if (o == this) {
			return 0;
		} else if (o instanceof Temps) {
			Temps t = (Temps) o;
			return this.secondes() - t.secondes();
		} else {
			throw new IllegalArgumentException("comparaison illegale");
		}
	}
	

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Temps)) { return false; }
		Temps t = (Temps) o;
		return this.secondes() == t.secondes();
	}
}
