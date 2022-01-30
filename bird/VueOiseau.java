package bird;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VueOiseau extends JPanel {
       private ArrayList<Oiseau> listeOiseaux = new ArrayList<Oiseau>();
       
       public VueOiseau() {
    	   this.setPreferredSize(new Dimension(800, 500));
    	   listeOiseaux.add((new Oiseau()));
       }
       
       
       public void dessiner(Graphics g) {
    	   this.repaint();
    	   ArrayList<Oiseau> list = new ArrayList<Oiseau>();
    	   
    	   for(Oiseau bird : listeOiseaux) {
    		   if(bird.getVisible()) {
    			   try {
    				   Image img = ImageIO.read(new File("C:\\Users\\Thomas\\Desktop\\image\\bird" + bird.getEtat() + ".png"));
    				   g.drawImage(img, bird.getPos(), bird.getHauteur(), 600/4, 469/4, this); // La taille des images est de 600x469
    				  }
    			   catch(IOException exc) {
    					exc.printStackTrace();
    				}
    			   list.add(bird);
    		   }
    		   
    	   }
    	   
    	   listeOiseaux = list;
    	   
       }
       
       
       
       @Override
       public void paint(Graphics g) {
    	   super.paint(g);
    	   dessiner(g);
       }
       
       
}
