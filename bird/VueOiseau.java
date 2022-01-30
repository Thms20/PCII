package bird;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Thomas
 *
 * La classe VueOiseau à la même fonction que la classe Affichage mais elle s'occupe de créer les
 * images d'un oiseau selon son état.
 */

public class VueOiseau extends JPanel {
       private ArrayList<Oiseau> listeOiseaux = new ArrayList<Oiseau>();
       
       public VueOiseau() {
    	   listeOiseaux.add((new Oiseau()));
       }
       
       
       public void dessiner(Graphics g) {
    //	   this.revalidate();
    //	   this.repaint();
    	   ArrayList<Oiseau> list = new ArrayList<Oiseau>();
    	   
    	   for(Oiseau bird : listeOiseaux) {
    		   if(bird.getVisible()) { // La condition permet de savoir si l'oiseau est encore dans la partie visible de la fenêtre
    			   try {
    				   /**
    				    * Pour récupérer une image j'utilise la classe image et ImageIO qui me
    				    * permettent d'aller chercher une image et la stocker dans une variable.
    				    * Il faut noter que l'adresse est à redéfinir pour vos propres
    				    * tests. La raison est expliquée plus en détail dans le rapport.
    				    */
    				   Image img = ImageIO.read(new File("C:\\Users\\Thomas\\Desktop\\image\\bird" + bird.getEtat() + ".png"));
    				   g.drawImage(img, bird.getPos(), bird.getHauteur(), 600/4, 469/4, this); // La taille des images est de 600x469
    				  }
    			   catch(IOException exc) {
    					exc.printStackTrace();
    				}
    			   list.add(bird);
    		   }
    		   
    	   }
    	   
    	   if((new Random()).nextInt(1000) < 5) { // 0.5% de chance qu'un nouvel oiseau apparaisse mais vu le temps très court c'est largement suffisant
    		   list.add(new Oiseau()); // J'ajoute un nouvel oiseau dans la liste
    	   }
    	   
    	   listeOiseaux = list;
    	   
       }
       
       
       
       @Override
       public void paint(Graphics g) {
    	   super.paint(g);
    	   dessiner(g);
       }
       
       
}
