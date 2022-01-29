package bird;
import java.util.Random;

public class Vol extends Thread{
   Random rand = new Random();
   public Control control;
   
   public Vol(Control c) {
	   control = c;
   }
   
   

@Override
   public void run() {
	while(control.etat.getHauteur() < control.affichage.getHauteurPanel() && !control.affichage.etat.testPerdu() ) {
	   
	   this.control.affichage.revalidate();
	   this.control.affichage.repaint();

       int h = control.etat.moveDown();
       control.affichage.setOval_Y(h);
       
       try { Thread.sleep(/*rand.nextInt(50)+10 */ 50); }
       catch (Exception e) { e.printStackTrace(); }
       
	}

   } 
}