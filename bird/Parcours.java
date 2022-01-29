package bird;
import  java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
	private ArrayList<Point> ListeDePoints =  new ArrayList<Point>();
	public Affichage aff;
	
	public int position = 1;
	private int score = 0;
	private final int decalageAbs = 50;
	
	public Parcours(Affichage a) {
		aff = a;
		int abscisse = aff.OVAL_X + aff.OVAL_WIDTH/2; //
		int ordonnee = 250;
		ListeDePoints.add(new Point(abscisse, ordonnee)); // 250 est la valeur en ordonnée de l'ovale +  la moitié de sa hauteur
		
		int newAbs = (new Random()).nextInt(aff.getLargeurPanel());
		
		while(abscisse < aff.getLargeurPanel()) {
			while(newAbs < abscisse) {
				newAbs = (new Random()).nextInt( 100 )+ (abscisse + decalageAbs);
			}
			abscisse = newAbs;
			newAbs = 0;
			if(abscisse >= aff.getLargeurPanel()) {
				ListeDePoints.add(new Point(abscisse, 250)); // Cela me permet de configurer l'ordonnée du dernier point 
			}
			else {
		//		int x = ordonnee;
		//		while(ordonnee > x + 50 || ordonnee < x - 50) {
		//	       	ordonnee = (new Random()).nextInt(aff.getHauteurPanel() - 50) + 50;
		//		}
				ordonnee = (new Random()).nextInt(aff.getHauteurPanel() - 50);
				if(ordonnee < 50)ordonnee+=50;
				
				ListeDePoints.add(new Point(abscisse, ordonnee));
			}
		}		
	}
	
	public ArrayList<Point> getPoints() {
		return ListeDePoints;		
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setParcours (ArrayList<Point> l) {
		ListeDePoints = l;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore() {
		score++;
	}
}
