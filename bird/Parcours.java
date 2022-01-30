package bird;
import  java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
	private ArrayList<Point> ListeDePoints =  new ArrayList<Point>();
	public Affichage aff;
	
	public int position = 1;
	private int score = 0;
	private final int decalageAbs = 100;
	
	
	
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
			int x = ordonnee;
			ordonnee = (new Random()).nextInt(aff.getHauteurPanel() - 75);
			
			while(Math.abs(ordonnee - x) > 200) {ordonnee = (new Random()).nextInt(aff.getHauteurPanel() - 75);}
			   // C'est pour éviter une différence trop importante et d'avoir un angle trop petit.
			
			if(ordonnee < 75)ordonnee+=75;
			ListeDePoints.add(new Point(abscisse, ordonnee));
		}		
	}
	
	
	
	
	
	public ArrayList<Point> getPoints() {
		return ListeDePoints;		
	}
	
	public int getPosition() {
		return position;
	}
	
	public int getDecalage() {
		return decalageAbs;
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
