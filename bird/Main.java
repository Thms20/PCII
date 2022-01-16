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
		
		JFrame fenetre = new JFrame("Main");
		aff.addMouseListener(control);
		fenetre.add(aff);
		
		fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 

}
