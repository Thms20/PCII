package bird;
import java.awt.Color;

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
		
		fenetre.add(oiseau); // J'ajoute le panel à la frame
		
        oiseau.add(aff); // Cela me permet de mettre les deux panels en même temps

        
		fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        vol.start();  // Le thread définit dans la classe Vol commence
        avancer.start(); // Le thread définit dans la classe Avancer commence
        
        
        (new Thread() {
        	
        	/**
        	 * Ici je centralise les mises à jour de l'affichage pour ne pas surcharger,
        	 * avec un nouveau Thread.
        	 */
            @Override
            public void run() {
                    while (true) {
                            try { Thread.sleep(40); }
                            catch (InterruptedException e) { e.printStackTrace(); }
                            aff.revalidate();
                            aff.repaint();
                            
                            oiseau.revalidate();
                            oiseau.repaint();
                    }
            }
          }).start();
   

	} 

}

