package com.troisieme.chrono;

import com.troisieme.chrono.Temps;
import com.troisieme.chrono.Coureur;

public class CoureurWithStats extends Coureur implements Comparable{
	private Temps meilleurTemps;
	private Temps tempsMoyen;
	private int nbreTours;
	private Temps pireTemps;
	
	public CoureurWithStats(){
		super();
		this.meilleurTemps = null;
		this.tempsMoyen = null;
		this.nbreTours = 0;
	}
	
	public CoureurWithStats(String nom){
		super(nom);
		this.meilleurTemps = null;
		this.tempsMoyen = null;
		this.pireTemps = null;
		this.nbreTours = 0;
	}
	
	public CoureurWithStats(String nom, Temps mT, Temps tM, int nT, Temps pT){
		super(nom);
		this.meilleurTemps = mT;
		this.tempsMoyen = tM;
		this.nbreTours = nT;
		this.pireTemps = pT;
	}
	
	public void setMeilleurTemps(Temps t){
		meilleurTemps = t;
	}

	public void setTempsMoyen(Temps t){
		tempsMoyen = t;
	}
	
	public void setNbreTours(int n){
		nbreTours = n;
	}
	
	public void setPireTemps(Temps t){
		pireTemps = t;
	}
	
	public Temps getTempsMoyen(){
		return tempsMoyen;
	}
	
	public Temps getMeilleurTemps(){
		return meilleurTemps;
	}
	
	public int getNbreTours(){
		return nbreTours;
	}

	public Temps getPireTemps(){
		return pireTemps;
	}
	
	@Override
	public int compareTo(Object o) {
		if (o == null) {
			throw new IllegalArgumentException("comparaison a null");
		} else if (o == this) {
			return 0;
		} else if (o instanceof CoureurWithStats) {
			CoureurWithStats c = (CoureurWithStats) o;
			return c.getNbreTours() - this.getNbreTours();
		} else {
			throw new IllegalArgumentException("comparaison illegale");
		}
	}
	
	
}
