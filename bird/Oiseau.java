package bird;

import java.util.Random;

/**
 * @author Thomas
 *
 * La classe Oiseau me permet d'implémenter un Thread pour permettre d'avancer vers la gauche 
 * pour un oiseau tous les "délais"ms.
 */

public class Oiseau extends Thread{
	private final int delai; // miliseconde
	private int etat;
	private int hauteur; // Ordonnée
	private int position; // Abscisse
	private boolean visible = true;
	
	public Oiseau() {
		delai = (new Random()).nextInt(50)+10; // Délai aléatoire pour ne pas avoir les mêmes vitesses entre les oiseaux
		hauteur = (new Random()).nextInt(400) + 50; // Ces valeurs sont prises pour que au moins une partie non négligeable de l'oiseau soit affiché si la valeur était le minimum ou le maximum (50 et 450 respectivement).
		position =  (new Random()).nextInt(100) + 800; // 800 étant la largeur de la fenêtre visible
		
		etat = 1; // Au début l'état de l'oiseau est la première image
		
		this.start(); // On commence le thread dans le constructeur car chaque oiseau créé aura son propre Thread
	}
	
	
	@Override
	public void run() {
		while(position > -150) { // -150 pour que l'image sorte complètement de la partie visible
			try { Thread.sleep(delai); }
		    catch (Exception e) { e.printStackTrace(); }
			
			position--;
			etat = (etat >= 8) ? 1:etat+1;
		}
		
		visible = false; // Si on sort de ce while alors l'oiseau n'est plus visible et sera notamment enlever de la liste définit dans VueOiseau.
	}

	 /** @return le délai */
	public int getDelai() {
		return delai;
	}
	
	 /** @return l'état qui est l'image que devra afficher la Vue */
	public int getEtat() {
		return etat;
	}
	
	 /** @return la hauteur */
	public int getHauteur() {
		return hauteur;
	}
	
	 /** @return la position */
	public int getPos() {
		return position;
	}
	
	 /** @return un boolean pour savoir si l'oiseau est visible ou non */
	public boolean getVisible () {
		return visible;
	}
	
	 /** Permet de changer la valeur de l'état */
	public void setEtat(int x) {
		etat = x;
	}
	
	 /** Permet de changer la valeur de la hauteur */
	public void setHauteur(int x) {
		hauteur = x;
	}
	
	 /** Permet de changer la valeur de la position */
	public void setPos(int x) {
		position = x;
	}
	

}
