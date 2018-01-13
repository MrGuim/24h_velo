package com.troisieme.classement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Vector;

import com.troisieme.chrono.Coureur;
import com.troisieme.chrono.CoureurWithStats;
import com.troisieme.chrono.Resultat;
import com.troisieme.chrono.Temps;

public class Classement {
	private Vector<Resultat> listeResultats = new Vector<Resultat>();
	private Vector<Resultat> meilleursResultats = new Vector<Resultat>(5);
	private Vector<Coureur> listeCoureurs = new Vector<Coureur>();
	private Vector<CoureurWithStats> listeCoureursWithStats = new Vector<CoureurWithStats>();
	private BufferedReader buff;
	private String file;
	
	public Classement(String fileName) {
		file = fileName;
		try{
		this.buff = new BufferedReader(new FileReader(fileName));
        String s = this.buff.readLine();
        while(s!=null){
        	String[] a = s.split(":");
        	Coureur coureur = new Coureur(a[0].trim());
        	Temps temps = new Temps(Integer.parseInt(a[1].trim()), Integer.parseInt(a[2]),Integer.parseInt(a[3]));
        	Resultat resultat = new Resultat(coureur, temps);
        	this.listeResultats.add(resultat);
            s = this.buff.readLine();
        }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Vector<Resultat> getListeResultats(){
		return this.listeResultats;
	}	
	
	public void makeListeCoureurs(){
		listeCoureurs.removeAllElements();
		for(int i=0; i<listeResultats.size(); i++){
			Coureur coureur = (listeResultats.elementAt(i)).getCoureur();
			if(!this.listeCoureurs.contains(coureur))
				this.listeCoureurs.add(coureur);
		}
	}
	
	public Vector<Coureur> getListeCoureurs(){
		return this.listeCoureurs;
	}
	
	public void updateResultat(){
		this.listeResultats.removeAllElements();
		try{
			this.buff = new BufferedReader(new FileReader(file));
	        String s = this.buff.readLine();
	        while(s!=null){
	        	String[] a = s.split(":");
	        	Coureur coureur = new Coureur(a[0].trim());
	        	Temps temps = new Temps(Integer.parseInt(a[1].trim()), Integer.parseInt(a[2]),Integer.parseInt(a[3]));
	        	Resultat resultat = new Resultat(coureur, temps);
	        	this.listeResultats.add(resultat);
	            s = this.buff.readLine();
	        }
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public Vector<String> listeCoureursToString(){
		Vector<String> listeCoureursString = new Vector<String>();
		for(int i = 0;i<this.listeCoureurs.size();i++)
			listeCoureursString.add(this.listeCoureurs.get(i).getNom());
		return listeCoureursString;
	}
	
	public void meilleursResultats(){
		Collections.sort(this.listeResultats);
		this.meilleursResultats.removeAllElements();
		meilleursResultats = new Vector<Resultat>();
		for(int i = 0; i<this.listeResultats.size(); i++) {
			this.meilleursResultats.add(this.listeResultats.elementAt(i));
		}
	}
	
	public Vector<Resultat> getMeilleursResultats(){
		return this.meilleursResultats;
	}
	
	public Temps moyenneVecTemps(Vector<Temps> v){
		int somme = 0;
		for(int i = 0; i<v.size(); i++){
			somme =+ v.get(i).secondes();
		}
		somme = somme/v.size();
		return new Temps(0,0,somme);
		
	}
	
	public void updateStats(){
		listeCoureursWithStats.removeAllElements();
		this.makeListeCoureurs();
		CoureurWithStats coureurWithStats;
		Vector<Temps> vecTemps = new Vector<Temps>();
		vecTemps.removeAllElements();
		for(int i = 0; i < listeCoureurs.size(); i++){
			for(int j = 0; j < listeResultats.size(); j++){
				if(listeCoureurs.get(i).equals(listeResultats.get(j).getCoureur()))
					vecTemps.addElement(listeResultats.get(j).getTemps());
			}
				coureurWithStats = new CoureurWithStats(listeCoureurs.get(i).getNom());
				Collections.sort(vecTemps);
				coureurWithStats.setMeilleurTemps(vecTemps.get(0));
				coureurWithStats.setPireTemps(vecTemps.lastElement());
				int somme = 0;
				for(int k = 0; k < vecTemps.size(); k++){
					somme = somme + vecTemps.get(k).secondes();
				}
				somme = somme/vecTemps.size();
				coureurWithStats.setTempsMoyen(new Temps(0,0,somme));
				coureurWithStats.setNbreTours(vecTemps.size());
				listeCoureursWithStats.addElement(coureurWithStats);
				vecTemps.removeAllElements();
		}
	}
	public Vector<CoureurWithStats> getListeCoureursWithStats(){
		return listeCoureursWithStats;
	}
	
}
