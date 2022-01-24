package bird;

import  java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
	private ArrayList<Point> ListeDePoints =  new ArrayList<Point>();
	public Affichage aff;
	
	public int position;
	private final int incr = 5;
	
	public Parcours(Affichage a) {
		aff = a;
		int abscisse = 200; // marche car au début j'ai mis 200 en x et y
		ListeDePoints.add(new Point(abscisse, 250)); // 250 est la valeur en ordonnée de l'ovale +  la moitié de sa hauteur
		
		int newAbs = (new Random()).nextInt(aff.getLargeurPanel());
		
		while(abscisse < aff.getLargeurPanel()) {
			
			while(newAbs < abscisse) {
				newAbs = (new Random()).nextInt(aff.getLargeurPanel() + 10);
			}
			abscisse = newAbs;
			newAbs = 0;
			if(abscisse >= aff.getLargeurPanel()) {
				ListeDePoints.add(new Point(abscisse, 250)); // Cela me permet de configurer l'ordonnée du dernier point 
			}
			else {
				ListeDePoints.add(new Point(abscisse, (new Random()).nextInt(aff.getHauteurPanel() - 50) + 50));
			}
		}		
	}
	
	public ArrayList<Point> getPoints() {
		return ListeDePoints;		
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition() {
		position+= incr;
	}
	
}

