package bird;

import javax.swing.JOptionPane;


/**
 * @author Thomas
 *
 * La classe Avancer me permet d'implémenter un Thread pour permettre aux points de la ligne
 * brisée d'avancer vers la gauche tous les 20ms.
 */

public class Avancer extends Thread{
	public Affichage aff;
	
	public Avancer(Affichage affichage) {
		aff = affichage;
	}
	
	
	@Override
	public void run() {
		
		
		while(!aff.etat.testPerdu()) {
	//		this.aff.revalidate();
	//		this.aff.repaint();
		    this.aff.etat.getP().setParcours(aff.etat.getParcours()); // Je mets à jour la liste de point du parcours.
		    try { Thread.sleep(20); }
	            catch (Exception e) { e.printStackTrace(); }
		
     	 }
		
		  /**
		   * Si testPerdu() renvoie faux alors la partie est finie JOptionPane me permet de faire
		   * apparaître une nouvelle fenêtre pour annoncer la fin et j'affiche en même temps le score
		   * qui est le nombre de points de la ligne brisée dépassé par l'ovale.
		   */
		   JOptionPane fin = new JOptionPane();
		   String s = "Votre score est de " + aff.etat.getP().getScore();
		   fin.showConfirmDialog(aff, s, "Perdu!", JOptionPane.DEFAULT_OPTION); 
	}

}
