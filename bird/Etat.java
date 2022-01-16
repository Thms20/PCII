package bird;

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
    static final int saut = 10; /** Valeur de différence en hauteur entre deux dessins */
    public Affichage aff;
	 
    public Etat(Affichage affichage) {
    	aff = affichage;
    }
    
    /** @return la hauteur */
    public int getHauteur() {
    	return hauteur;
    }
    
    
    /** @return la valeur d'un saut */
    public int getSaut() {
    	return saut;
    }
    
    /** Permet de varier la valeur de hauteur (+/- saut selon si on veut descendre ou monter l'image)
     * si elle ne dépasse pas les bornes.
     * @return la valeur de hauteur.
     */
    public int jump() {
    	if(hauteur - saut > 0 && hauteur + saut < aff.getHauteurPanel()) // Regarder si ça dépasse pas les bornes définies dans Affichage, à faire quand même package
    	   hauteur-=saut; 
    	return hauteur;
    }
}
