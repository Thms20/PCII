package bird;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
* 
* @author Thomas
* 
* La classe Etat est la classe de mod�le du MVC. Il contient les informations qui caract�risent 
* l'�tat de l'affichage et un changement de ces informations entra�ne un changement au niveau 
* de l'interface graphique.
*
*/

public class Etat {
	public static int hauteur = 200; /** Valeur �gale � la hauteur de l'ovale */
   static final int saut = 40; /** Valeur de diff�rence en hauteur entre deux dessins */
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
    * si elle ne d�passe pas les bornes.
    * @return la valeur de hauteur.
    */
   public int jump() {
   	if(hauteur - saut > -50) // Regarder si �a d�passe pas les bornes d�finies dans Affichage, � faire quand m�me package
   	   hauteur-=saut; 
   	return hauteur;
   }
   
   /** Permet de baisser la valeur de hauteur 
    * si elle ne d�passe pas les bornes.
    * @return la valeur de hauteur.
    */
   public int moveDown() {
   	if(hauteur + 80 < aff.getHauteurPanel())
    	   hauteur+=5; 
    return hauteur;
   }
   
   /** @return le parcours */
   public Parcours getP() {
	   return parcours;
   }
  
   /** @return la liste de points mise � jours. 
    * Permet d'ajouter des nouveaux points quand le dernier point de la liste est visible
    *  */
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
		   ordonnee = (new Random()).nextInt(aff.getHauteurPanel() - 75);
		   
		   while(Math.abs(ordonnee - ldp.get(ldp.size()-1).y) > 200) { ordonnee = (new Random()).nextInt(aff.getHauteurPanel() - 75);}
		   // C'est pour �viter une diff�rence trop importante et de ne pas avoir un angle trop petit.
		   
		   if(ordonnee < 75)ordonnee+=75;
		   list.add(new Point( (new Random()).nextInt( 100 ) + ldp.get(ldp.size()-1).x + parcours.getDecalage(), ordonnee));
	   }
	   return list;
   }
   
   
   
   /** @return un boolean pour savoir si les extr�mit�s de l'ovale touche la ligne bris�e */
   public boolean testPerdu(){
	   int fx;
	   Point p1, p2;
	   if(parcours.getPoints().get(1).x > aff.OVAL_X + aff.OVAL_WIDTH/2) { 
	       p1 = parcours.getPoints().get(0);
	       p2 = parcours.getPoints().get(1);
	   }
	   else { // Si l'abscisse du deuxi�me point est inf�rieur � l'abscisse du centre de l'ovale alors l'ovale est entre le deuxi�me et troisi�me point
		   p1 = parcours.getPoints().get(1);
	       p2 = parcours.getPoints().get(2);
	   }
	   
	   /**
	    * Quelle est la formule qui permet de d�terminer la valeur de l�ordonn�e sur la ligne bris�e au 
	    * point d�abscisse correspondant � la position 0 de l�ovale, connaissant les coordonn�es relatives
	    *  des points suivants et pr�c�dents ?
	    *  - C'est l'interpolation lin�aire : f(x) = ya + (x- xa) * (yb-ya)/(xb-xa)
	    */
	   
	   fx = (int) (p1.y + ( (parcours.getPosition() + aff.OVAL_X + aff.OVAL_WIDTH/2) - p1.x) * (float)(p2.y - p1.y)/(p2.x - p1.x));
       // Ici j'utilise la formule de l'interpolation lin�aire pour avoir une coordonn�e en ordonn�e.
	   
	   
	   if(fx <= (hauteur+50)-(aff.OVAL_HEIGHT/2) || fx >= (hauteur+50)+(aff.OVAL_HEIGHT/2)) {
		   return true; // Egalit� permettant de savoir la ligne bris�e touche les extr�mit�s de l'ovale.
	   }
	   return false;
   }
}


