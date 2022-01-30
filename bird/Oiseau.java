package bird;

import java.util.Random;

/**
 * @author Thomas
 *
 * La classe Oiseau me permet d'impl�menter un Thread pour permettre d'avancer vers la gauche 
 * pour un oiseau tous les "d�lais"ms.
 */

public class Oiseau extends Thread{
	private final int delai; // miliseconde
	private int etat;
	private int hauteur; // Ordonn�e
	private int position; // Abscisse
	private boolean visible = true;
	
	public Oiseau() {
		delai = (new Random()).nextInt(50)+10; // D�lai al�atoire pour ne pas avoir les m�mes vitesses entre les oiseaux
		hauteur = (new Random()).nextInt(400) + 50; // Ces valeurs sont prises pour que au moins une partie non n�gligeable de l'oiseau soit affich� si la valeur �tait le minimum ou le maximum (50 et 450 respectivement).
		position =  (new Random()).nextInt(100) + 800; // 800 �tant la largeur de la fen�tre visible
		
		etat = 1; // Au d�but l'�tat de l'oiseau est la premi�re image
		
		this.start(); // On commence le thread dans le constructeur car chaque oiseau cr�� aura son propre Thread
	}
	
	
	@Override
	public void run() {
		while(position > -150) { // -150 pour que l'image sorte compl�tement de la partie visible
			try { Thread.sleep(delai); }
		    catch (Exception e) { e.printStackTrace(); }
			
			position--;
			etat = (etat >= 8) ? 1:etat+1;
		}
		
		visible = false; // Si on sort de ce while alors l'oiseau n'est plus visible et sera notamment enlever de la liste d�finit dans VueOiseau.
	}

	 /** @return le d�lai */
	public int getDelai() {
		return delai;
	}
	
	 /** @return l'�tat qui est l'image que devra afficher la Vue */
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
	
	 /** Permet de changer la valeur de l'�tat */
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
