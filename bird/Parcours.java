package bird;
import  java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Thomas
 *
 * La classe Parcours me permet de créer le parcours de points qui permettra de créer la ligne
 * brisée. Les premiers points sont définis aléatoirement dans le constructeur. Le reste est
 * est construit dans la classe état qui met à jour la liste de points de la classe Parcours.
 */

public class Parcours {
	private ArrayList<Point> ListeDePoints =  new ArrayList<Point>();
	public Affichage aff;
	
	public int position = 1; // C'est la valeur à laquelle se déplace chaque points en abscisse.
	private int score = 0; // C'est le score qui est affiché en fin de partie.
	private final int decalageAbs = 100; // C'est un décalage minimum entre chaque abscisse de chaque point.
	
	
	
	public Parcours(Affichage a) {
		aff = a;
		int abscisse = aff.OVAL_X + aff.OVAL_WIDTH/2; // C'est pour avoir la valeur en abscisse du centre de l'ovale.
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
	
	
	
	
	 /** @return la liste de points */
	public ArrayList<Point> getPoints() {
		return ListeDePoints;		
	}
	
	/** @return la position (voir définition l.18) */
	public int getPosition() {
		return position;
	}
	
	/** @return le décalage en abscisse */
	public int getDecalage() {
		return decalageAbs;
	}
	
	/** Permet de mettre à jour la liste de points */
	public void setParcours (ArrayList<Point> l) {
		ListeDePoints = l;
	}
	
	/** @return le score */
	public int getScore() {
		return score;
	}
	
	/** Permet d'augmenter le score de 1 */
	public void setScore() {
		score++;
	}
}
