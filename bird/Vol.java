package bird;

/**
 * @author Thomas
 *
 * La classe Vol me permet d'implémenter un Thread pour permettre à l'ovale de tomber toutes les 
 * 50ms.
 */

public class Vol extends Thread{
   public Control control;
   
   public Vol(Control c) {
	   control = c;
   }
   
   

@Override
   public void run() {

	while(control.etat.getHauteur() < control.affichage.getHauteurPanel() && !control.affichage.etat.testPerdu()) {
	   
	//   this.control.affichage.revalidate();
	//   this.control.affichage.repaint();

       int h = control.etat.moveDown();
       control.affichage.setOval_Y(h); // Permet de mettre à jour la nouvelle valeur en ordonnée de l'ovale pour l'affichage
       
       try { Thread.sleep(50); }
       catch (Exception e) { e.printStackTrace(); }
       
	}

   } 
}