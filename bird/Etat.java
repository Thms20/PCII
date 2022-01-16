package bird;

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
    static final int saut = 10; /** Valeur de diff�rence en hauteur entre deux dessins */
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
     * si elle ne d�passe pas les bornes.
     * @return la valeur de hauteur.
     */
    public int jump() {
    	if(hauteur - saut > 0 && hauteur + saut < aff.getHauteurPanel()) // Regarder si �a d�passe pas les bornes d�finies dans Affichage, � faire quand m�me package
    	   hauteur-=saut; 
    	return hauteur;
    }
}
