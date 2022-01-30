package bird;
import javax.swing.JFrame;


/** 
 * 
 * @author Thomas
 * 
 * La classe Main permet de relier les classes entre elles et contient le code lu et donc excécuté.
 *
 */

public class Main {

	public static void main(String[] args) {
		
		Affichage aff = new Affichage();
		Etat etat = new Etat(aff);
		Control control = new Control(etat, aff);
		Vol vol = new Vol(control);
		
		Parcours parcours = new Parcours(aff);
		Avancer avancer = new Avancer(aff);
		
		VueOiseau oiseau = new VueOiseau();
		
		JFrame fenetre = new JFrame("Main");
		aff.addMouseListener(control);
		
		fenetre.add(oiseau);
		
        oiseau.add(aff);

        
		fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        vol.start();
        avancer.start(); 
   

	} 

}

/*
 * Quelle est la formule qui permet de déterminer la valeur de l’ordonnée sur la ligne brisée au 
 * point d’abscisse correspondant à la position 0 de l’ovale, connaissant les coordonnées relatives
 *  des points suivants et précédents ?
 *  - C'est l'interpolation linéaire : f(x) = ya + (x- xa) * (yb-ya)/(xb-xa)
 */
