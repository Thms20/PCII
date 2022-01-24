import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

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
   	if(hauteur - saut > 0) // Regarder si ça dépasse pas les bornes définies dans Affichage, à faire quand même package
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
   /*
   public ArrayList<Point> getParcours() {
	   ArrayList<Point> ldp = parcours.getPoints();
	   ArrayList<Point> list = new ArrayList<Point>();
	   for(int i = 0; i < ldp.size() - 1; i++) {
		   ldp.get(i).x -= parcours.getPosition();
		   if(ldp.get(i + 1).x - parcours.getPosition() > 0) {
			   list.add(ldp.get(i));
		   }
	   }
	   list.add(new Point(ldp.get(ldp.size()-1).x - parcours.getPosition(), ldp.get(ldp.size()-1).y));
	   return list;
   }
   */
   public ArrayList<Point> getParcours() {
	   ArrayList<Point> ldp = parcours.getPoints();
	   ArrayList<Point> list = new ArrayList<Point>();
	   for(int i = 0; i < ldp.size() - 1; i++) {
		   ldp.get(i).x -= parcours.getPosition();
		   if(ldp.get(i + 1).x - parcours.getPosition() > 0) {
			   list.add(ldp.get(i));
		   }
	   }
	   
	   list.add(new Point(ldp.get(ldp.size()-1).x - parcours.getPosition(), ldp.get(ldp.size()-1).y));
	   
	   if(ldp.get(ldp.size()-1).x <= aff.getLargeurPanel()) {
		   list.add(new Point( (new Random()).nextInt( 100 ) + ldp.get(ldp.size()-1).x + 50, (new Random()).nextInt(aff.getHauteurPanel() - 50) + 50));
	   }
	   return list;
   }
}


