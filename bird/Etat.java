package bird;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
* 
* @author Thomas
* 
* La classe Etat est la classe de modèle du MVC. Il contient les informations qui caractérisent 
* l'état de l'affichage et un changement de ces informations entraîne un changement au niveau 
* de l'interface graphique.
*
*/

public class Etat {
	public static int hauteur = 200; /** Valeur égale à la hauteur de l'ovale */
   static final int saut = 40; /** Valeur de différence en hauteur entre deux dessins */
   public Affichage aff;
   public Parcours parcours; 
	 
   public Etat(Affichage affichage) {
   	aff = affichage;
   	parcours = new Parcours(aff);
   }
   
   /** @return la hauteur */
   public int getHauteur() {
   	return hauteur;
   }
   
   
   /** @return la valeur d'un saut */
   public int getSaut() {
   	return saut;
   }
   
   /** Permet d'augmenter la valeur de hauteur 
    * si elle ne dépasse pas les bornes.
    * @return la valeur de hauteur.
    */
   public int jump() {
   	if(hauteur - saut > -50) // Regarder si ça dépasse pas les bornes définies dans Affichage, à faire quand même package
   	   hauteur-=saut; 
   	return hauteur;
   }
   
   /** Permet de baisser la valeur de hauteur 
    * si elle ne dépasse pas les bornes.
    * @return la valeur de hauteur.
    */
   public int moveDown() {
   	if(hauteur + 80 < aff.getHauteurPanel())
    	   hauteur+=5; 
    return hauteur;
   }
   
   public Parcours getP() {
	   return parcours;
   }
  
   
   public ArrayList<Point> getParcours() {
	   ArrayList<Point> ldp = parcours.getPoints();
	   ArrayList<Point> list = new ArrayList<Point>();
	   for(int i = 0; i < ldp.size() - 1; i++) {
		   ldp.get(i).x -= parcours.getPosition();
		   
		   if(ldp.get(i).x == aff.OVAL_X + aff.OVAL_WIDTH/2) parcours.setScore(); // Ici j'augmente le score de 1 quand l'ovale passe un point
		   
		   if(ldp.get(i + 1).x - parcours.getPosition() > 0) {
			   list.add(ldp.get(i));
		   }
	   }
	   
	   list.add(new Point(ldp.get(ldp.size()-1).x - parcours.getPosition(), ldp.get(ldp.size()-1).y));
	   
	   
	   if(ldp.get(ldp.size()-1).x <= aff.getLargeurPanel()) {
		   int ordonnee;
		   ordonnee = (new Random()).nextInt(aff.getHauteurPanel() - 50);
		   if(ordonnee < 50)ordonnee+=50;
		   list.add(new Point( (new Random()).nextInt( 100 ) + ldp.get(ldp.size()-1).x + 50, ordonnee));
	   }
	   return list;
   }
   
   
   public boolean testPerdu(){
	   int fx;
	   Point p1, p2;
	   if(parcours.getPoints().get(1).x > aff.OVAL_X + aff.OVAL_WIDTH/2) { 
	       p1 = parcours.getPoints().get(0);
	       p2 = parcours.getPoints().get(1);
	   }
	   else { // Si le deuxième point est inférieur à l'abscisse du centre de l'ovale alors l'ovale est entre le deuxième et troisième point
		   p1 = parcours.getPoints().get(1);
	       p2 = parcours.getPoints().get(2);
	   }
	   fx = (int) (p1.y + ( (parcours.getPosition() + aff.OVAL_X + aff.OVAL_WIDTH/2) - p1.x) * (float)(p2.y - p1.y)/(p2.x - p1.x));

	   if(fx <= (hauteur+50)-(aff.OVAL_HEIGHT/2) || fx >= (hauteur+50)+(aff.OVAL_HEIGHT/2)) {
		   return true;
	   }
	   return false;
   }
}


