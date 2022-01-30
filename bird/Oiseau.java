package bird;

import java.util.Random;

public class Oiseau extends Thread{
	private final int delai; // miliseconde
	private int etat;
	private int hauteur; // Ordonnée
	private int position; // Abscisse
	private boolean visible = true;
	
	public Oiseau() {
		delai = (new Random()).nextInt(50)+10;
		hauteur = (new Random()).nextInt(400) + 50;
		position =  (new Random()).nextInt(100) + 800; // 800 étant la largeur de la fenêtre visible
		
		etat = 1; // Au début l'état de l'oiseau est la première image
		
		this.start();
	}
	
	
	@Override
	public void run() {
		while(position > -150) { // -150 pour que l'image sorte complètement de la partie visible
			try { Thread.sleep(delai); }
		    catch (Exception e) { e.printStackTrace(); }
			
			position--;
			etat = (etat >= 8) ? 1:etat+1;
		}
		
		visible = false;
	}

	
	public int getDelai() {
		return delai;
	}
	
	public int getEtat() {
		return etat;
	}
	
	public int getHauteur() {
		return hauteur;
	}
	
	public int getPos() {
		return position;
	}
	
	public boolean getVisible () {
		return visible;
	}
	
	public void setEtat(int x) {
		etat = x;
	}
	
	public void setHauteur(int x) {
		hauteur = x;
	}
	
	public void setPos(int x) {
		position = x;
	}
	

}
